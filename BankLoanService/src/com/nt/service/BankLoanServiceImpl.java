 package com.nt.service;

public class BankLoanServiceImpl implements BankLoanService {

	@Override
	public float calltrAmt(float pAmt, float rate, float time) throws IllegalArgumentException {
		float intrAmt=0.0f;
		
		if(pAmt<=0||rate<=0||time<=0) {
			throw new IllegalArgumentException("invalid inputs");
			
			
		}
		intrAmt=(pAmt*rate*(time/100.0f));
		return intrAmt;
	}

}
