package com.st.ats.model;

import java.util.Date;



import lombok.Data;
/**
 * this is Entity class for ats user which is bind repository to send data in database
 * 
 * @author SAUMYA
 *
 */
@Data
public class AtsUser {
	
	private Long userId;
	
	private String fname;
	
	private String lname;
	
	private String email;
	
	private String gender;
	
	private Date  dob;
	
	private Long phno;
	
	private String createdBY;
	
	private String updatedBy;
	
}
