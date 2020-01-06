package com.usa.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class VeichleRegistrationDTO {
	private String regCenter;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date regDate;
	private String regNumber;

}
