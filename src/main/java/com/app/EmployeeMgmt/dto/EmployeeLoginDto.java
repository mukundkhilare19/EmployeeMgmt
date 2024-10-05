package com.app.EmployeeMgmt.dto;


public class EmployeeLoginDto {
    private String empEmail;
    private String password;
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "EmployeeLoginDto [empEmail=" + empEmail + ", password=" + password + "]";
	}

    // Getters and Setters
}
