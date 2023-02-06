package com.employeechallenge.employeesapi.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

import static com.employeechallenge.employeesapi.miscmethods.DateFormat.getLocalDate;
import static com.employeechallenge.employeesapi.miscmethods.DateFormat.getStringLocalDate;

// Entity class with JPA annotations for mapping to database
@Entity(name="Employee")
@Table(
        name="employees",
        uniqueConstraints = {@UniqueConstraint(name="employee_email_unique", columnNames = "email")}
)
public class Employee {
    @Id
    @SequenceGenerator(
            name="employee_id",
            sequenceName = "employee_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_id"
    )
    @Column(name="employee_id", updatable = false)
    private Long id;
    @Column(name="first_name", columnDefinition = "TEXT", nullable = false)
    private String firstName;
    @Column(name="last_name", columnDefinition = "TEXT", nullable = false)
    private String lastName;
    @Column(name="email", columnDefinition = "TEXT", nullable = false)
    private String email;
    @Column(name="department", columnDefinition = "TEXT", nullable = false)
    private String department;
    @Column(name="roles", columnDefinition = "TEXT", nullable = false)
    private String roles;
    @Column(name="salary", nullable = false)
    private Double salary;
    @Column(name = "start_date", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate startDate;
    @Column(name = "is_employed")
    private boolean isEmployed;

    // Constructors (with args and no args). One for DateTime as string for Json POST/PUT conversion, one with DateTime
    public Employee() {
    }
    //
    public Employee(String firstName, String lastName, String email,
                    String department, String roles, Double salary, boolean isEmployed, String startDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.roles = roles;
        this.salary = salary;
        setEmployed(isEmployed);
        this.startDate = getLocalDate(startDate);
    }
    public Employee(String firstName, String lastName, String email,
                    String department, String roles, Double salary, Boolean isEmployed, LocalDate startDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.roles = roles;
        this.salary = salary;
        setEmployed(isEmployed);
        this.startDate = startDate;
    }

    public Employee(Employee emp) {

    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getEmployed() {
        return isEmployed;
    }

    public void setEmployed(Boolean employed) {
        isEmployed = employed;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(String date) {
        this.startDate = getLocalDate(date);
    }
    public String getStringStartDate() {
        return getStringLocalDate(this.startDate);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + id +
                ", First Name: " + firstName +
                ", Last Name: " + lastName +
                ", Email: " + email +
                ", Department: " + department +
                ", Role: '" + roles +
                ", Salary: £" + salary +
                ", Employed: " + isEmployed +
                ", Start Date: " + startDate +
                "}";
    }
}
