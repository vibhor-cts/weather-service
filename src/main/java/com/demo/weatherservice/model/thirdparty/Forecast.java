package com.demo.weatherservice.model.thirdparty;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Forecast {

	@JsonProperty("dt")
	private long forecastDatetime;
	
	@JsonProperty("main")
	private TemperatureData temperatureData;
	
	@JsonProperty("weather")
	private List<WeatherData> weatherDataList;

	public long getForecastDatetime() {
		return forecastDatetime;
	}

	public void setForecastDatetime(long forecastDatetime) {
		this.forecastDatetime = forecastDatetime;
	}

	public TemperatureData getTemperatureData() {
		return temperatureData;
	}

	public void setTemperatureData(TemperatureData temperatureData) {
		this.temperatureData = temperatureData;
	}

	public List<WeatherData> getWeatherDataList() {
		return weatherDataList;
	}

	public void setWeatherDataList(List<WeatherData> weatherDataList) {
		this.weatherDataList = weatherDataList;
	}
	
}



