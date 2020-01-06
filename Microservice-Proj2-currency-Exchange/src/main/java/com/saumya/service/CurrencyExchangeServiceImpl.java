package com.saumya.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.saumya.pojo.CurrencyConvertionPojo;
import com.saumya.pojo.CurrencyExchangePojo;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService{
    //private static final String CURRENCY_CONVERTION_URL="http://localhost:1111/getCurrencyCost/from/"+from+"/to/"+to+"";
	@Override
	public CurrencyExchangePojo getTotalExchangeValue(String from,String to,Integer quantity ) {
		
		CurrencyConvertionPojo webClient = WebClient.create().get()
		        .uri("localhost:1111/getCurrencyCost/from/"+from+"/to/"+to+"",quantity)
		        .retrieve()
		        .bodyToMono(CurrencyConvertionPojo.class).block();
		        
		
		//calculate currency
		Double currencyValue=webClient.getCurrencyValue();
		Double finalCurrencyAmount=currencyValue*quantity;
		
		
		//convert the CurrencyExchange to currencyConvertionPojo
		CurrencyExchangePojo pojo=new CurrencyExchangePojo();
	    pojo.setCurrencyForm(webClient.getCurrencyForm());
	    pojo.setCurrencyTo(webClient.getCurrencyTo());
	    pojo.setCurrencyExchangeValue(finalCurrencyAmount);
		return pojo;
	}
   
}
