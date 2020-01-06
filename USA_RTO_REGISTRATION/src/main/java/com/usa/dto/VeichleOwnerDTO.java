package com.usa.dto;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class VeichleOwnerDTO {
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dob;
	private Long phnNo;
	
}
