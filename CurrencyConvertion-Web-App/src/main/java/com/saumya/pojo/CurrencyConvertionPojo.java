package com.saumya.pojo;

import lombok.Data;

@Data
public class CurrencyConvertionPojo {
	private Integer currencyId;
	private String from;
	private String to;
	private Double quantity;


}
