package com.saumya.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saumya.entity.CurrencyExchangeEntity;

@Repository
public interface CurrencyExchangeRepositary extends JpaRepository<CurrencyExchangeEntity, Integer> {

	@Query("from CurrencyExchangeEntity where currencyForm=:from and currencyTo=:to")
	public CurrencyExchangeEntity findCurrencyValByFromAndTo(String from,String to);
}
