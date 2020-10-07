package com.hikari.confg.service;

import com.hikari.confg.dao.EmployeeDao;
import com.hikari.confg.model.Employee;

public class EmployeeService {
	EmployeeDao empDao = null;
	public EmployeeService() {
		empDao = new EmployeeDao();
	}
	public Employee getEmployee(String id) {
		return empDao.getEmployee(id);
	}
}
