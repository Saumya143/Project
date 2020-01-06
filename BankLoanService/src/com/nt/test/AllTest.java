package com.nt.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nt.service.BankLoanService;
import com.nt.service.BankLoanServiceImpl;

public class AllTest {
	private static BankLoanService service=null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("AllTest.setUpBeforeClass()");
		service=new BankLoanServiceImpl(); 
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AllTest.tearDownAfterClass()");
		service=null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("AllTest.setUp()");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("AllTest.tearDown()");
	}

	@Test
	public void testCalltrAmt() {
		float pAmt=10000;
		float rate=2;
		float time=20;
		float expectedintrAmt=4000f;
		float actualintrAmt=0.0f;
		//get actual results
		actualintrAmt=service.calltrAmt(10000, 2, 20);
		assertEquals(expectedintrAmt,actualintrAmt,0.0f);
		
	}
	
	@Test
	public void testCalltrAmtDeltaValues() {
		float pAmt=10000;
		float rate=2;
		float time=20;
		float expectedintrAmt=3992f;
		float actualintrAmt=0.0f;
		//get actual results
		actualintrAmt=service.calltrAmt(10000, 2, 20);
		assertEquals(expectedintrAmt,actualintrAmt,10.0f);
	}
		
	@Test(expected=IllegalArgumentException.class)
	public void testCalltrAmtwithZero() {
		float pAmt=10000;
		float rate=2;
		float time=20;
		float expectedintrAmt=240000f;
		float actualintrAmt=0.0f;
		//get actual results
		actualintrAmt=service.calltrAmt(-10000, 2, 20);
		assertEquals(expectedintrAmt,actualintrAmt,0.0f);
		//fail("Exception is expected but not raised");
	}
	
}
