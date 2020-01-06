package com.usa.bo;



import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class VeichleOwnerBO {
	
	//private Integer veichleOwnerId;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dob;
	private Long phnNo;
	
}
