package com.prajjwal.weather.service;

import org.springframework.stereotype.Service;

import com.prajjwal.weather.domain.Weather;

@Service
public class WeatherService {

	public Weather getWeatherByZipcode(Integer zipCode) {
		return new Weather(zipCode, "Weather is good");
	}
}
