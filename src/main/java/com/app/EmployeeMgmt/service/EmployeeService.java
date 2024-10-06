package com.app.EmployeeMgmt.service;

import com.app.EmployeeMgmt.entity.Employee;
import com.app.EmployeeMgmt.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveOrUpdateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int empId) {
        return employeeRepository.findById(empId);
    }

    public void deleteEmployeeById(int empId) {
        employeeRepository.deleteById(empId);
    }

    public Optional<Employee> updateEmployee(int id, Employee employeeDetails) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setEmpName(employeeDetails.getEmpName());
            existingEmployee.setEmpEmail(employeeDetails.getEmpEmail());
            existingEmployee.setEmpMobile(employeeDetails.getEmpMobile());
            existingEmployee.setEmpSal(employeeDetails.getEmpSal());

            return Optional.of(employeeRepository.save(existingEmployee));
        } else {
            return Optional.empty();
        }
    }
}
