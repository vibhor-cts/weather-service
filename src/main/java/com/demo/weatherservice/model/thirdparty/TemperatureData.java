package com.demo.weatherservice.model.thirdparty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemperatureData {
	
	@JsonProperty("temp")
	private double temperature;
	
	@JsonProperty("temp_min")
	private double minTemperature;
	
	@JsonProperty("temp_max")
	private double maxTemperature;

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getMinTemperature() {
		return minTemperature;
	}

	public void setMinTemperature(double minTemperature) {
		this.minTemperature = minTemperature;
	}

	public double getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(double maxTemperature) {
		this.maxTemperature = maxTemperature;
	}
	
}
