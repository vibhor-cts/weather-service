package com.demo.weatherservice.config;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class CacheConfig {

    @Scheduled(fixedRate = 3000)
    @CacheEvict(value = { "forecastCache" })
    public void clearCache() {  
    }
}
