package com.ant.myteam.dao;

import com.ant.myteam.model.Employee;

public interface EmployeeDao {

	public boolean addEmployee(Employee emp);
	
	public Employee findEmployeeById(long empId);
}
