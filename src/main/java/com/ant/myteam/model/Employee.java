package com.ant.myteam.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long empId;
	
	@Column(nullable=false)
	private String firstName;
	
	@Column(nullable=false)
	private String lastName;
	
	
	private String gender;
	private String company;
	private String team;
	private String phone;
	private String job;
	private String imagePath;
	private String email;
	
	@ManyToOne
	@JoinColumn(name="deptId")
	private Department department;
	
	public Long getEmpId() {
		return empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public String getCompany() {
		return company;
	}

	public String getTeam() {
		return team;
	}

	public String getPhone() {
		return phone;
	}

	public String getJob() {
		return job;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getEmail() {
		return email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
