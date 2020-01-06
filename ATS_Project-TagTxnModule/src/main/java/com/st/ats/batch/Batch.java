package com.st.ats.batch;

public interface Batch {

	public Long preProcess();
	
	public void start();
	
	public void process(String email,Long phno,Long txnId,String fname,String lname);
	
	public void postProcess();
	
}
