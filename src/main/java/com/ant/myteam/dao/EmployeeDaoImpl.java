package com.ant.myteam.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ant.myteam.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addEmployee(Employee emp) {
		try {
			sessionFactory.getCurrentSession().save(emp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Employee findEmployeeById(long empId) {
		Employee result = new Employee();
		try {
			result = (Employee) sessionFactory.getCurrentSession().get(
					Employee.class, empId);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
