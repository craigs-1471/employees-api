package com.employeechallenge.employeesapi.controllers;

import com.employeechallenge.employeesapi.models.Employee;
import com.employeechallenge.employeesapi.service.impl.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// http://localhost:8081/api/employees
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    // Employee service field
    private EmployeeService employeeService;

    // Constructor with EmployeeService dependency injection
    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // Add Employee POST REST API method
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // Employee get all employees REST API method
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get Employee by Id REST API method
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    // Update Employee REST API method
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,
                                                   @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    // Delete Employee by id REST API method
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully!", HttpStatus.OK);
    }

    // Change Employee status by id REST API method
    @PutMapping("/employed/{id}")
    public ResponseEntity<Employee> changeEmployeeStatus(@PathVariable("id") long id) {
        return new ResponseEntity<Employee>(employeeService.changeEmploymentStatus(id), HttpStatus.OK);
    }
}
