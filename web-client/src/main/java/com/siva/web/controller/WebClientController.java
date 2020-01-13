package com.siva.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.siva.web.repository.WebRepository;

@RestController
public class WebClientController {
	
	@Autowired
	WebRepository repository;
	
	@GetMapping("/webclient/cart/{name}")
	public String testCart(@PathVariable String name) {
		return this.repository.getProductName(name);
	}
	
	@GetMapping("/webclient/payment/{paymentId}")
	public String testPayment(@PathVariable int paymentId) {
		return this.repository.getPaymentDetails(paymentId);
	}

}
