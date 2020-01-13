package com.siva.payment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@GetMapping("/getPaymentDetails/{paymentId}")
	public String getPaymentDetails(@PathVariable int paymentId) {
		return "Payment id is : "+paymentId;
	}

}
