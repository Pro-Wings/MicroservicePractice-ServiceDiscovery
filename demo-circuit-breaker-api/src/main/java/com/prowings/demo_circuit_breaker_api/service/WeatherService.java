package com.prowings.demo_circuit_breaker_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class WeatherService {

	private final RestTemplate restTemplate;

	@Autowired
	public WeatherService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@CircuitBreaker(name = "weatherService", fallbackMethod = "fallbackWeather")
	public String getWeather(String city) {
		//https://api.openweathermap.org/data/2.5/weather?lat=18.6298&lon=73.7997&appid=aea2c2eaeb4020c7d96e8c22ce8d0bb2
		
		String url = "https://api.openweathermap.org/data/2.5/weather?lat=18.6298&lon=73.7997&appid=aea2c2eaeb4020c7d96e8c22ce8d0b";
		return restTemplate.getForObject(url, String.class);
	}

	public String fallbackWeather(String city, Throwable t) {
		return "Weather data is currently unavailable for given LAT LONG";
	}
}
