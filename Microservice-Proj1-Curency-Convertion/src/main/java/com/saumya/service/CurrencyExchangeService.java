package com.saumya.service;

import com.saumya.pojo.CurrencyExchangePojo;

public interface CurrencyExchangeService {
	public CurrencyExchangePojo findByCurrecyFromToCurrencyTo(String from,String to);

}
