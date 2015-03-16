package com.ant.myteam.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant.myteam.dao.EmployeeDao;
import com.ant.myteam.model.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService, Serializable {

	private static final long serialVersionUID = 1L;

//	private List<Employee> empList = new ArrayList<Employee>();

//	public EmployeeServiceImpl() {
//		Employee emp1 = new Employee();
//		emp1.setEmpId(1L);
//		emp1.setFirstName("Huong");
//		emp1.setLastName("Nguyen");
//
//		Employee emp2 = new Employee();
//		emp2.setEmpId(2L);
//		emp2.setFirstName("Khang");
//		emp2.setLastName("Le");
//
//		empList.add(emp1);
//		empList.add(emp2);
//	}
	
	@Autowired
	private EmployeeDao empDao;

	@Override
	public Employee findEmployeeById(long empId) {		
		return empDao.findEmployeeById(empId);
	}

	@Override
	public boolean addEmployee(Employee emp) {
		return empDao.addEmployee(emp);
	}
	
	

}
