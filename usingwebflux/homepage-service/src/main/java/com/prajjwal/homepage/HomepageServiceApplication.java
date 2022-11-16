package com.prajjwal.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class HomepageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomepageServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public WebClient.Builder webCLientBuilder() {
		return WebClient.builder();
	}
}
