package com.demo.weatherservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class WeatherServiceExceptionAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { NoDataFoundException.class })
	protected ResponseEntity<Object> handleNoDataFound(NoDataFoundException ex, WebRequest request) {
		String bodyOfResponse = "No forecast data found for given city";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler(value = { WebClientResponseException.class })
	protected ResponseEntity<Object> handleWebClientResponseException(WebClientResponseException ex, WebRequest request) {
		String bodyOfResponse = "No city found";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(value = { ThirdPartyApiException.class })
	protected ResponseEntity<Object> handleThirdPartyApiException(ThirdPartyApiException ex, WebRequest request) {
		String bodyOfResponse = "The service is not available, please try after some time..";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}


