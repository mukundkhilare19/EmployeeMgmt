package com.app.EmployeeMgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EmployeeMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMgmtApplication.class, args);
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		    String rawPassword = "password123";
		    String encodedPassword = encoder.encode(rawPassword);
		    
		    System.out.println("Encoded password: " + encodedPassword);
		    
		    boolean matches = encoder.matches("password123", encodedPassword);
		    System.out.println("Password matches: " + matches);
	}

}
