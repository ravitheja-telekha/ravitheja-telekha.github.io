package com.telekha.empinfo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Employee")
public class Employee {
	@Id
	private String id;
	private String empid;
   
	private String salary;
	
	private String email;
	private String bloodgrp;
	private EmployeeStatus status;
	private EmployeeDesig desigopt;
	private EmployeeReport reportusers;
	private String uname;
	private String gender;
	private String password;
	private String confirmpassword;
	private String firstname;
	private String lastname;
	private String designation;
    private String mobilenumber;
    private String address;
   
 
    
	

	

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	

	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBloodgrp() {
		return bloodgrp;
	}

	public void setBloodgrp(String bloodgrp) {
		this.bloodgrp = bloodgrp;
	}

	public EmployeeStatus getStatus() {
		return status;
	}

	public void setStatus(EmployeeStatus status) {
		this.status = status;
	}

	public EmployeeDesig getDesigopt() {
		return desigopt;
	}

	public void setDesigopt(EmployeeDesig desigopt) {
		this.desigopt = desigopt;
	}

	public EmployeeReport getReportusers() {
		return reportusers;
	}

	public void setReportusers(EmployeeReport reportusers) {
		this.reportusers = reportusers;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getDesignation() {
		return designation;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
