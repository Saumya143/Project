package com.st.ats.model;

import lombok.Data;

/**
 * this class is use as helper class for 
 * for our atsUser for creating password
 *  
 * @author Saumya
 *
 */
@Data
public class AtsUserHelper {

	private String email;
	private String tempPwd;
	private String confirmPazzword;
	private String pazzword;
	
}
