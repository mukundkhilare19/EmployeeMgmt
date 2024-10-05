package com.app.EmployeeMgmt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees") 
public class Employee {
	
	@Id
	private int empId;
	private String empName;
	@Column(nullable = false, unique = true)
	
	private String empEmail;
	private long empMobile;
	private long empSal;
	 private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public long getEmpMobile() {
		return empMobile;
	}
	public void setEmpMobile(long empMobile) {
		this.empMobile = empMobile;
	}
	public long getEmpSal() {
		return empSal;
	}
	public void setEmpSal(long empSal) {
		this.empSal = empSal;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empMobile="
                + empMobile + ", empSal=" + empSal + ", password=" + password + "]";
	}
	
	

}
