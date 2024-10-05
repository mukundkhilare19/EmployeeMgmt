package com.app.EmployeeMgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.EmployeeMgmt.entity.Employee;
import com.app.EmployeeMgmt.repo.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create or update an employee
    public Employee saveOrUpdateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get an employee by ID
    public Optional<Employee> getEmployeeById(int empId) {
        return employeeRepository.findById(empId);
    }

    // Delete an employee by ID
    public void deleteEmployeeById(int empId) {
        employeeRepository.deleteById(empId);
    }
}
