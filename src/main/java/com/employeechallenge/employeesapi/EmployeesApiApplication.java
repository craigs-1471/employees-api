package com.employeechallenge.employeesapi;

import com.employeechallenge.employeesapi.models.Employee;
import com.employeechallenge.employeesapi.repositories.EmployeeRepository;
import com.employeechallenge.employeesapi.service.impl.EmployeeServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Service layer
@SpringBootApplication
public class EmployeesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository, EmployeeServiceImpl employeeService) {
		return args -> {

			// Create employees and add to database
			Employee emp = new Employee("Spencer", "Craig", "spenny@email.com", "IT",
					"Systems Maintenance", 32000.00, true, "2023 03 04");
			employeeService.saveEmployee(emp);

			// Change employed status
			long employeeId = 1L;
			employeeService.changeEmploymentStatus(employeeId);
		};
	}
}


