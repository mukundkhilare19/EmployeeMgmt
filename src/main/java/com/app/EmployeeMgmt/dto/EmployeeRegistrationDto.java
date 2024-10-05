package com.app.EmployeeMgmt.dto;



public class EmployeeRegistrationDto {
    private String empName;
    private String empEmail;
    private long empMobile;
    private long empSal;
    private String password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "EmployeeRegistrationDto [empName=" + empName + ", empEmail=" + empEmail + ", empMobile=" + empMobile
				+ ", empSal=" + empSal + ", password=" + password + "]";
	}
  
    // Getters and Setters
}
