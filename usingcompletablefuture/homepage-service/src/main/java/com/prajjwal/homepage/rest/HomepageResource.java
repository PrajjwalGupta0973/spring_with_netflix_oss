package com.prajjwal.homepage.rest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prajjwal.homepage.domain.Homepage;
import com.prajjwal.homepage.domain.Stock;
import com.prajjwal.homepage.domain.Weather;
import com.prajjwal.homepage.service.HomepageService;

@RestController
@RequestMapping("/api/v1")
public class HomepageResource {

	@Autowired
	private HomepageService homepageService;

	@GetMapping("/telstra/homepage/{zipCode}")
	public ResponseEntity<Homepage> getHomePage(@PathVariable("zipCode") Integer zipCode)
			throws InterruptedException, ExecutionException {
		// Note that making two call on homepageService for weather and stock and
		// combining here because @Async works only on proxied object. Internal method
		// call within the same object (homepageService) will not have effect of async
		CompletableFuture<Weather> weatherAsFuture = homepageService.getWeather(zipCode);
		CompletableFuture<Stock> stockAsFuture = homepageService.getStock("TLS");
		return ResponseEntity.ok(new Homepage(weatherAsFuture.get(), stockAsFuture.get()));
	}
}
