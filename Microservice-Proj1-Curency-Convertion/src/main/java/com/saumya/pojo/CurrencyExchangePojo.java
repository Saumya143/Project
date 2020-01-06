package com.saumya.pojo;

import lombok.Data;

@Data
public class CurrencyExchangePojo {
	private Integer currencyId;
	private String currencyForm;
	private String currencyTo;
	private Double currencyValue;

}
