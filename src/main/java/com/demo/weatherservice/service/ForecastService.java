package com.demo.weatherservice.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.demo.weatherservice.alerts.HighTemperatureAlertDecorator;
import com.demo.weatherservice.alerts.RainAlertDecorator;
import com.demo.weatherservice.exception.NoDataFoundException;
import com.demo.weatherservice.exception.ThirdPartyApiException;
import com.demo.weatherservice.model.ForecastResponse;
import com.demo.weatherservice.model.thirdparty.Forecast;
import com.demo.weatherservice.model.thirdparty.Forecasts;
import com.demo.weatherservice.model.thirdparty.WeatherData;

@Service
public class ForecastService {
	
	private static final int DAYS_FOR_FORECAST = 3;
	
	private static final int FORECAST_PER_DAY = 8;
	
	private static final String HTTP_SUCCESS_CODE = "200";
	
	@Value("${forecastapi.url}")
	private String forecastApiUrl;
	
	@Value("${appid}")
	private String appid;

	@Cacheable(cacheNames = {"forecastCache"}, key = "#city")
	public List<ForecastResponse> getForecasts(String city) throws NoDataFoundException, ThirdPartyApiException {
		System.out.println("calling");
		WebClient client = WebClient.create(forecastApiUrl);

		WebClient.ResponseSpec responseSpec = client.get()
			.uri(builder -> 
				builder
				.path("/forecast")
				.queryParam("q", city)
				.queryParam("appid", appid)
				.queryParam("cnt", DAYS_FOR_FORECAST * FORECAST_PER_DAY)
				.queryParam("units", "metric")
				.build())
		    .retrieve();
		Optional<Forecasts> forecasts = Optional.of(responseSpec.bodyToMono(Forecasts.class).block());
		
		if (forecasts.isPresent() && forecasts.get().getStatusCode().equals(HTTP_SUCCESS_CODE)) {
			List<ForecastResponse> response = mapResponse(forecasts.get().getForecasts());
			response = new RainAlertDecorator().addAlert(response);
			response = new HighTemperatureAlertDecorator().addAlert(response); 
			return response;
		} else if (!forecasts.get().getStatusCode().equals(HTTP_SUCCESS_CODE)) {
			throw new ThirdPartyApiException();
		} else {
			throw new NoDataFoundException();
		}
	}

	private List<ForecastResponse> mapResponse(List<Forecast> forecastList) {
		List<ForecastResponse> responseList = new ArrayList<ForecastResponse>(); 
		
		Instant current = Instant.now().truncatedTo(ChronoUnit.DAYS);
		for (int i=0; i<=2; i++) {
			ForecastResponse forecastResponse = new ForecastResponse();
			Instant startDay = current.plus(i, ChronoUnit.DAYS);
			Instant endDay = current.plus(i+1, ChronoUnit.DAYS);
			double minTempForDay = Integer.MAX_VALUE;
			double maxTempForDay = Integer.MIN_VALUE;
			for (Forecast forecast : forecastList) {
				Instant forecastInstant = Instant.ofEpochSecond(forecast.getForecastDatetime());
				if ((forecastInstant.equals(startDay) || forecastInstant.isAfter(startDay)) && forecastInstant.isBefore(endDay)) {
					minTempForDay = (minTempForDay > forecast.getTemperatureData().getMinTemperature()) ? forecast.getTemperatureData().getMinTemperature() : minTempForDay;
					maxTempForDay = (maxTempForDay < forecast.getTemperatureData().getMaxTemperature()) ? forecast.getTemperatureData().getMaxTemperature() : maxTempForDay;
					forecastResponse.getConditionIds().addAll(getConditionIds(forecast));
				}
			}
			forecastResponse.setDate(startDay);
			forecastResponse.setMinTemperature(minTempForDay);
			forecastResponse.setMaxTemperature(maxTempForDay);
			responseList.add(forecastResponse);
		}
		return responseList;
	}

	private Set<Integer> getConditionIds(Forecast forecast) {
		Set<Integer> conditionIds = new HashSet<>();
		for (WeatherData data : forecast.getWeatherDataList()) {
			conditionIds.add(data.getId());
		}
		return conditionIds;
	}

}
