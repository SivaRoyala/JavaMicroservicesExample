package com.siva.cart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@GetMapping("/getProductDetails/{name}")
	public String getProductDetails(@PathVariable String name) {
		return "Product name is :"+name;
	}

}
