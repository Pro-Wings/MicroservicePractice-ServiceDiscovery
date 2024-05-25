package com.prowings.demo_circuit_breaker_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.demo_circuit_breaker_api.service.WeatherService;

@RestController
public class WeatherController {
	
	private final WeatherService weatherService;

	@Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/{city}")
    public String getWeather(@PathVariable String city) {
        return weatherService.getWeather(city);
    }

}
