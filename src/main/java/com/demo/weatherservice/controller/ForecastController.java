package com.demo.weatherservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.weatherservice.exception.NoDataFoundException;
import com.demo.weatherservice.exception.ThirdPartyApiException;
import com.demo.weatherservice.model.ForecastResponse;
import com.demo.weatherservice.service.ForecastService;

@RestController
public class ForecastController {

	@Autowired
	private ForecastService service;
	
	@GetMapping("/forecasts")
	public List<ForecastResponse> getForecast(@RequestParam(name = "city", required = true) String city) throws NoDataFoundException, ThirdPartyApiException {
		List<ForecastResponse> forecasts = service.getForecasts(city);
		return forecasts;
	}
	
}
