package com.employeechallenge.employeesapi.service.impl;

import com.employeechallenge.employeesapi.exceptions.ResourceNotFoundException;
import com.employeechallenge.employeesapi.models.Employee;
import com.employeechallenge.employeesapi.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service layer
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    // Constructor with EmployeeRepository dependency
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    // Service layer method for addEmployee POST API method
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Service layer method for getAllEmployees GET API method
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Service layer method for getEmployeeById GET/{id} API method
    @Override
    public Employee getEmployeeById(long id) {
        // Check if employee exists in database. Get employee if exists, throw exception if not
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            return employee.get();
        }
        else
            throw new ResourceNotFoundException("Employee", "Id", id);
    }

    // Service layer method for updateEmployee PUT API method.
    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // Check if employee exists in database and throw if not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id)
        );

        // Update and save employee in database
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setRoles(employee.getRoles());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setEmployed(employee.getEmployed());
        existingEmployee.setStartDate(employee.getStringStartDate());

        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }

    // Service layer method for deleteEmployee DELETE API method
    @Override
    public void deleteEmployee(long id) {

        // Check if employee exists in database, throw if not
        employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id)
        );
        // Delete employee
        employeeRepository.deleteById(id);
    }

    // Service layer method for changeEmploymentStatus PUT API method.
    @Override
    public Employee changeEmploymentStatus(long id) {
        // Check if employee exists in database
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id)
        );

        // Update and save employee status in database
        existingEmployee.setEmployed(!existingEmployee.getEmployed());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }
}
