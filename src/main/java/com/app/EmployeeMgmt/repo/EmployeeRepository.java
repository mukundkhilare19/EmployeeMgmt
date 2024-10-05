package com.app.EmployeeMgmt.repo;

import com.app.EmployeeMgmt.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByEmpEmail(String empEmail);  // Custom method to find by email
}
