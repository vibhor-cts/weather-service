package com.demo.weatherservice.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastResponse {

	@JsonProperty("date")
	private Instant date;

	private double minTemperature;

	private double maxTemperature;

	private List<String> alerts = new ArrayList<String>();

	@JsonIgnore
	private Set<Integer> conditionIds = new HashSet<Integer>();
	
	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
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

	public List<String> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<String> alerts) {
		this.alerts = alerts;
	}

	public Set<Integer> getConditionIds() {
		return conditionIds;
	}

	public void setConditionIds(Set<Integer> conditionIds) {
		this.conditionIds = conditionIds;
	}
	
	
}
