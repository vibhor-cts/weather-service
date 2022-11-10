package com.demo.weatherservice.alerts;

import java.util.List;

import com.demo.weatherservice.model.ForecastResponse;

public class HighTemperatureAlertDecorator implements AlertDecorator{

	private static final double TEMP_THRESHOLD = 40.0;
	
	private static final String ALERT = "Use sunscreen lotion";
	
	@Override
	public List<ForecastResponse> addAlert(List<ForecastResponse> responseList) {
		for(ForecastResponse response : responseList) {
			boolean isHighTempPredicted = (response.getMinTemperature() > TEMP_THRESHOLD) || (response.getMaxTemperature() > TEMP_THRESHOLD);;
			if (isHighTempPredicted) {
				response.getAlerts().add(ALERT);
			}
		}
		return responseList;
	}

}
