package com.employeechallenge.employeesapi.repositories;

import com.employeechallenge.employeesapi.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
