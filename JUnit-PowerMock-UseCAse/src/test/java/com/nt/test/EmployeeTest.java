package com.nt.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.nt.dao.EmployeeDao;
import com.nt.service.EmployeeService;
@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.nt.service")
public class EmployeeTest {

	public EmployeeDao empDao;
	public EmployeeService service;
	String status;
	
	
	
	@Test
	public void testEmployee() {
		service=new EmployeeService();
	    //create mock  object for emp
		empDao=PowerMockito.mock(EmployeeDao.class);
		//seting dummy behavior for this class
		PowerMockito.when(empDao.findEmployeeId(102)).thenReturn("101");
		//PowerMockito.when(empDao.findEmployeeId()).thenReturn(102);
		//PowerMockito.when(empDao.findEmployeeId()).thenReturn(103);
		
		service.setEmpDao(empDao);
		
		service.featchEmployeeId(102);
	
		assertNotNull(service);
	}
	@Test 
	  public void testCustomerId()throws Exception { //create service class
	  service= new EmployeeService();
	  
	  empDao=PowerMockito.mock(EmployeeDao.class);
	  PowerMockito.when(empDao.findCustomerId(101)).thenReturn("102");
	  service.setEmpDao(empDao); 
	  System.out.println(); 
	  //create mock object for
	  String status=Whitebox.invokeMethod(service,"featchCustomerId",101);
	  assertNotNull(status); 
	  System.out.println(status);
	  
	  }
	 
}
