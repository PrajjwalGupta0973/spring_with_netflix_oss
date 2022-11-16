package com.prajjwal.homepage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.prajjwal.homepage.domain.Homepage;
import com.prajjwal.homepage.domain.Stock;
import com.prajjwal.homepage.domain.Weather;

import reactor.core.publisher.Mono;

@Service
public class HomepageService {

	@Autowired
	private WebClient.Builder webClientBuilder;

	public Mono<Homepage> getHomepage(Integer zipCode) {
		//@formatter:off
		Mono<Weather> weatherMono= webClientBuilder
				.baseUrl("http://WEATHER-SERVICE")
				.build()
				.get()
				.uri(uriBuilder -> uriBuilder
				.path("/api/v1/weather/{zipCode}").build(zipCode))
				.retrieve()
				.bodyToMono(Weather.class);
		Mono<Stock> stockMono= webClientBuilder
				.baseUrl("http://STOCK-SERVICE")
				.build().get()
				.uri(uriBuilder -> uriBuilder
				.path("/api/v1/stock/{stockCode}").build("TLS"))
				.retrieve()
				.bodyToMono(Stock.class);
		//@formatter:on
		return Mono.zip(weatherMono, stockMono, Homepage::new);
	}
}
