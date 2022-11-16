package com.prajjwal.homepage.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prajjwal.homepage.domain.Homepage;
import com.prajjwal.homepage.service.HomepageService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class HomepageResource {

	@Autowired
	private HomepageService homepageService;

	@GetMapping("/telstra/homepage/{zipCode}")
	public Mono<Homepage> getHomePage(@PathVariable("zipCode") Integer zipCode) {
		return homepageService.getHomepage(zipCode);
	}
}
