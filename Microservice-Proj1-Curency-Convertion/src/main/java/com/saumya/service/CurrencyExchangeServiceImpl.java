package com.saumya.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saumya.entity.CurrencyExchangeEntity;
import com.saumya.pojo.CurrencyExchangePojo;
import com.saumya.repositary.CurrencyExchangeRepositary;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

	@Autowired
	CurrencyExchangeRepositary repo;
	
	@Override
	public CurrencyExchangePojo findByCurrecyFromToCurrencyTo(String from, String to) {
		CurrencyExchangePojo pojo=null;
		pojo=new CurrencyExchangePojo();
		CurrencyExchangeEntity currencyValByFromAndTo = repo.findCurrencyValByFromAndTo(from, to);
		BeanUtils.copyProperties(currencyValByFromAndTo, pojo);
		return pojo;
	}

}
