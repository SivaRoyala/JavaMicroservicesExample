package com.siva.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.siva.web.repository.WebRemoteRepository;
import com.siva.web.repository.WebRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class WebClientApplication {
	
	public static final String CART_SERVICE_URL = "http://CART-CLIENT";
	public static final String PAYMENT_SERVICE_URL = "http://PAYMENT-CLIENT";

	public static void main(String[] args) {
		SpringApplication.run(WebClientApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public WebRepository accountRepository(){
		return new WebRemoteRepository(CART_SERVICE_URL, PAYMENT_SERVICE_URL);
	}

}
