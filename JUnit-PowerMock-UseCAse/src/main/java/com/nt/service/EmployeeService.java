package com.nt.service;

import com.nt.dao.EmployeeDao;

public class EmployeeService {

	private EmployeeDao empDao;

	public void setEmpDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}

	public String featchEmployeeId(int id) {
		String empId = empDao.findEmployeeId(id);
		return empId;
	}
	
	private String featchCustomerId(int id1) {
		String customerId=empDao.findCustomerId(id1);
		return customerId;
	}
}
