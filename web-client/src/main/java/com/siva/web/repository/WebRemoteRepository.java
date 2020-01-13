package com.siva.web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class WebRemoteRepository implements WebRepository {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	protected String cartServiceUrl;
	protected String paymentServiceUrl;
	
	public WebRemoteRepository(String cartServiceUrl, String paymentServiceUrl) {
		this.cartServiceUrl = cartServiceUrl.startsWith("http") ? cartServiceUrl
				: "http://" + cartServiceUrl;
		
		this.paymentServiceUrl = paymentServiceUrl.startsWith("http") ? paymentServiceUrl
				: "http://" + paymentServiceUrl;
	}
	

	@Override
	public String getProductName(String name) {
		return restTemplate.getForObject(cartServiceUrl+"/cart/getProductDetails/"+name, String.class);
	}

	@Override
	public String getPaymentDetails(int paymentId) {
		return restTemplate.getForObject(paymentServiceUrl+"/payment/getPaymentDetails/"+paymentId, String.class);
	}

}
