package com.prajjwal.weather.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prajjwal.weather.domain.Weather;
import com.prajjwal.weather.service.WeatherService;

@RestController
@RequestMapping("/api/v1")
public class WeatherResource {

	@Autowired
	private WeatherService weatherService;

	@GetMapping("/weather/{zipCode}")
	public ResponseEntity<Weather> getWeather(@PathVariable("zipCode") Integer zipCode) {
		return ResponseEntity.ok(weatherService.getWeatherByZipcode(zipCode));
	}
}
