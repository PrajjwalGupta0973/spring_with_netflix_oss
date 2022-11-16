package com.prajjwal.homepage.service;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.prajjwal.homepage.domain.Homepage;
import com.prajjwal.homepage.domain.Stock;
import com.prajjwal.homepage.domain.Weather;

import reactor.core.publisher.Mono;

@Service
public class HomepageService {

	@Autowired
	private RestTemplate restTemplate;

	@Async
	public CompletableFuture<Weather> getWeather(Integer zipCode) {
		URI uri = UriComponentsBuilder.fromUriString("http://WEATHER-SERVICE").path("/api/v1/weather/{zipCode}")
				.build(zipCode);
		Weather weather = restTemplate.getForObject(uri, Weather.class);
		return CompletableFuture.completedFuture(weather);
	}

	@Async
	public CompletableFuture<Stock> getStock(String stockCode) {
		URI uri = UriComponentsBuilder.fromUriString("http://STOCK-SERVICE").path("/api/v1/stock/{stockCode}")
				.build(stockCode);
		Stock stock = restTemplate.getForObject(uri, Stock.class);
		return CompletableFuture.completedFuture(stock);
	}
}
