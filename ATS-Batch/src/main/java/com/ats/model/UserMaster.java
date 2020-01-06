package com.ats.model;

import lombok.Data;

@Data
public class UserMaster {
	
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private Long mobileNo;
	private String gender;

}
