package com.demo.weatherservice.model;

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
	
}

class TemperatureData {
	
	@JsonProperty("temp")
	private double temperature;
	
	@JsonProperty("temp_min")
	private double minTemperature;
	
	@JsonProperty("temp_max")
	private double maxTemperature;
}

class WeatherData {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("main")
	private String main;
	
}


