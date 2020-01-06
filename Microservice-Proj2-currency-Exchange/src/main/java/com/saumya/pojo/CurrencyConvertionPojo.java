package com.saumya.pojo;

import lombok.Data;

@Data
public class CurrencyConvertionPojo {
	private Integer currencyId;
	private String currencyForm;
	private String currencyTo;
	private Double currencyValue;


}
