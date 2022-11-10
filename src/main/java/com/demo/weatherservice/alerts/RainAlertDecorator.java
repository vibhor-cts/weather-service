package com.demo.weatherservice.alerts;

import java.util.List;

import com.demo.weatherservice.model.ForecastResponse;

public class RainAlertDecorator implements AlertDecorator {

	private static final int RAIN_MIN_ID = 500;
	
	private static final int RAIN_MAX_ID = 599;
	
	private static final String ALERT = "Carry umbrella";
	
	@Override
	public List<ForecastResponse> addAlert(List<ForecastResponse> responseList) {
		
		for(ForecastResponse response : responseList) {
			boolean isRainPredicted = response.getConditionIds().stream().anyMatch(id -> (id >= RAIN_MIN_ID && id <= RAIN_MAX_ID));
			if (isRainPredicted) {
				response.getAlerts().add(ALERT);
			}
		}
		return responseList;
	}

}
