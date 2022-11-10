package com.demo.weatherservice.model.thirdparty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherData {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("main")
	private String main;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}
	
}
