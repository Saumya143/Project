package com.saumya.service;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.saumya.pojo.CurrencyConvertionPojo;

@Service
public class CurrencyConvertionWebServiceImpl implements CurrencyConvertionWebService {

	@Override
	public CurrencyConvertionPojo convertCurency() {
	
		CurrencyConvertionPojo webClient = WebClient.create().get()
		        .uri("localhost:2222/getCurrencyValue/from/{from}/to/{to}/quantity/{quantity}")
		        .retrieve()
		        .bodyToMono(CurrencyConvertionPojo.class).block();
		     
		        
		
		return webClient;
	}

}
