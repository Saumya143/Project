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
	
	@GetMapping(value="/getCurrencyCost/from/{from}/to/{to}")
	
	public CurrencyExchangePojo getCurencyCostDetails(@PathVariable("from")String from,@PathVariable("to")String to) {
		
		CurrencyExchangePojo findByCurrecyFromToCurrencyTo = service.findByCurrecyFromToCurrencyTo(from, to);
		return findByCurrecyFromToCurrencyTo;
		
	}

}
