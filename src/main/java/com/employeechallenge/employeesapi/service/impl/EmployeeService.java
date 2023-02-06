package com.employeechallenge.employeesapi.service.impl;

import com.employeechallenge.employeesapi.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id);
    void deleteEmployee(long id);
    Employee changeEmploymentStatus(long id);
}
