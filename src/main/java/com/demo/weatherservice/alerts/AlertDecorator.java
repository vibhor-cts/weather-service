package com.demo.weatherservice.alerts;

import java.util.List;

import com.demo.weatherservice.model.ForecastResponse;

interface AlertDecorator {

	List<ForecastResponse> addAlert(List<ForecastResponse> responseList);
	
}
