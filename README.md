# weather-service
Micro service for weather forecast

# Features
1. Weather forecast for next 3 days for given city
2. Also provides weather conditions and precautions to take on a forecast day

# Design

# Assumptions
. The service is running behind a gateway and gateway is assumed to take care of security. 

# Implementation
. This service is implemented using Spring Boot framework and makes use of Spring Web, Spring Webflux and Spring Cache modules
. Maven is used for dependency management and build
. To add weather alerts to forecast, Decorator design pattern is implemeted

# Running the service
. Environment variable APP_ID needs to be created before this service can be run.
. Being a Spring Boot project, the project can be run as a jar and runs on port 8080. 
. The application can be accessed at http://localhost:8080/forecasts?city={city}, where city can be any city you want to get forecast for

# TODOs 
There are many items which needs to be done
. Secrets need to be served from Vault
. An advanced cache implementation like Redis is to be used
. Logging needs to be implemented
. Refactoring to be done, like creating constants for error messages, query parameters, etc.
. Configuration of the service needs to be separated from the code




