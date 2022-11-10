# weather-service
Micro service for weather forecast

# Features
1. Weather forecast for next 3 days for given city
2. Also provides weather conditions and precautions to take on a forecast day

# Design
Please take a look at the architecture diagram in project root directory

# Assumptions
1. The service is running behind a gateway and gateway is assumed to take care of security. 

# Implementation
1. This service is implemented using Spring Boot framework and makes use of Spring Web, Spring Webflux and Spring Cache modules
2. Maven is used for dependency management and build
3. To add weather alerts to forecast, Decorator design pattern is implemeted

# Running the service
1. Environment variable APP_ID needs to be created before this service can be run.
2. Being a Spring Boot project, the project can be run as a jar and runs on port 8080. 
3. The application can be accessed at http://localhost:8080/forecasts?city={city}, where city can be any city you want to get forecast for

# TODOs 
There are many items which needs to be done
1. Secrets need to be served from Vault
2. An advanced cache implementation like Redis is to be used
3. Logging needs to be implemented
4. Refactoring to be done, like creating constants for error messages, query parameters, etc.
5. Configuration of the service needs to be separated from the code
