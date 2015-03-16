package com.ant.myteam.service;

import com.ant.myteam.model.Employee;

public interface EmployeeService {
	public Employee findEmployeeById(long empId);
	
	public boolean addEmployee(Employee emp);
}
