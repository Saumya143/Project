package com.usa.bo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class VeichleRegistrationBO {
	private String regCenter;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date regDate;
	private String regNumber;

}
