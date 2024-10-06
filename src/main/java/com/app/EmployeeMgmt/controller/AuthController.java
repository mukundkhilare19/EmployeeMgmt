package com.app.EmployeeMgmt.controller;

import com.app.EmployeeMgmt.dto.EmployeeLoginDto;
import com.app.EmployeeMgmt.entity.Employee;
import com.app.EmployeeMgmt.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Registration
    @PostMapping("/register")
    public ResponseEntity<String> registerEmployee(@RequestBody Employee employee) {
        if (employeeRepository.findByEmpEmail(employee.getEmpEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists.");
        }

        // Hash the password before saving
        String rawPassword = employee.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // Log raw and encoded passwords for debugging
        System.out.println("Register - Raw password: " + rawPassword);
        System.out.println("Register - Encoded password: " + encodedPassword);

        employee.setPassword(encodedPassword);
        employeeRepository.save(employee);

        return ResponseEntity.ok("Registration successful");
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<String> loginEmployee(@RequestBody EmployeeLoginDto loginDto) {
        Optional<Employee> employee = employeeRepository.findByEmpEmail(loginDto.getEmpEmail());

        if (employee.isPresent()) {
            String storedPassword = employee.get().getPassword();
            String rawPassword = loginDto.getPassword();
            
            // Log stored and raw passwords for debugging
            System.out.println("Login - Stored encoded password: " + storedPassword);
            System.out.println("Login - Raw password: " + rawPassword);

            // Check if the passwords match
            boolean passwordsMatch = (storedPassword.equals(rawPassword)) ? true : false;//  passwordEncoder.matches(rawPassword, storedPassword);
            System.out.println("Login - Passwords match: " + passwordsMatch);

            if (passwordsMatch) {
                return ResponseEntity.ok("Login successful!");
            } else {
                return ResponseEntity.badRequest().body("Invalid credentials.");
            }
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials.");
        }
    }
}
