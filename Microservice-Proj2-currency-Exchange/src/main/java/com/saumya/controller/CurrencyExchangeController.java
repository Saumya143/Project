 package com.saumya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.saumya.pojo.CurrencyExchangePojo;
import com.saumya.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {
	@Autowired
	CurrencyExchangeService service;
	
	@GetMapping(value="/getCurrencyValue/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyExchangePojo showExchangeCurrencyValue(@PathVariable("from")String from, @PathVariable("to")String to,@PathVariable("quantity") Integer quantity ) {
		CurrencyExchangePojo totalExchangeValue = service.getTotalExchangeValue(from, to, quantity);
		
		return totalExchangeValue;
		
	}

}
