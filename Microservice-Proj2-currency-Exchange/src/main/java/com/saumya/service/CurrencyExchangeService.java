package com.saumya.service;

import com.saumya.pojo.CurrencyExchangePojo;

public interface CurrencyExchangeService {
	
	public CurrencyExchangePojo getTotalExchangeValue(String from,String to,Integer quantity);

}
