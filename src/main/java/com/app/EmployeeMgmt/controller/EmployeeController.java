package com.app.EmployeeMgmt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.EmployeeMgmt.entity.Employee;
import com.app.EmployeeMgmt.repo.EmployeeRepository;
import com.app.EmployeeMgmt.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;
    // Create or Update Employee
    @PostMapping
    public ResponseEntity<Employee> createOrUpdateEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveOrUpdateEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Get all Employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Get Employee by ID
    @GetMapping("/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId) {
        Optional<Employee> employee = employeeService.getEmployeeById(empId);
        return employee.map(emp -> new ResponseEntity<>(emp, HttpStatus.OK))
                       .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete Employee by ID
    @DeleteMapping("/{empId}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable int empId) {
        employeeService.deleteEmployeeById(empId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    // Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employeeDetails) {
        // Find the employee by ID
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        
        if (optionalEmployee.isPresent()) {
            // Get the existing employee from the database
            Employee existingEmployee = optionalEmployee.get();

            // Update the employee's details
            existingEmployee.setEmpName(employeeDetails.getEmpName());
            existingEmployee.setEmpEmail(employeeDetails.getEmpEmail());
            existingEmployee.setEmpMobile(employeeDetails.getEmpMobile());
            existingEmployee.setEmpSal(employeeDetails.getEmpSal());

            // Save the updated employee back to the database
            Employee updatedEmployee = employeeRepository.save(existingEmployee);

            // Return the updated employee data
            return ResponseEntity.ok(updatedEmployee);
        } else {
            // Return 404 if employee not found
            return ResponseEntity.notFound().build();
        }
    }

}
