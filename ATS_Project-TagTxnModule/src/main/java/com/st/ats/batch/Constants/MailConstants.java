package com.st.ats.batch.Constants;

/**
 * This is used to set mail constant in mailutils class 
 * 
 * @author SAUMYA
 *
 */
public interface MailConstants {
	
	/**
	 * this is used to replace first_name place holder from mail template 
	 */
	public static final String FNAME_PHOLDER="{FIRST_NAME}";
	/**
	 * this is used to replace last_name place holder from mail template 
	 */
	public static final String LNAME_PHOLDER="{LAST_NAME}";
	
	public static final String LOWBL_REM_EMAIL_TEMPLATE_FILE="lowbalEmail.txt";
	
	
	public static final String SUBJECT_FOR_LOW_BAL_MAIL="ATS_LOW_BAL_REMINDER";
			
}

