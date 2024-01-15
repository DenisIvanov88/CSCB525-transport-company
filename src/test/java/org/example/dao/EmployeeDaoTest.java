package org.example.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByNameStartingWith() {
        System.out.println("\n Name starts with Emp1: ");
        EmployeeDao.findByNameStartingWith("Emp1").stream().forEach(System.out::println);
    }

    @Test
    void employeesFindBySalaryBetween() {
        System.out.println("\n Salary is between 1800 and 2200: ");
        EmployeeDao.employeesFindBySalaryBetween(1800, 2200).stream().forEach(System.out::println);
    }

    @Test
    void employeesFindBySalaryGreaterThan() {
        System.out.println("\n Salary is greater than 2000: ");
        EmployeeDao.employeesFindBySalaryGreaterThan(2000).stream().forEach(System.out::println);
    }

    @Test
    void employeesFindBySalaryLessThan() {
        System.out.println("\n Salary is less than 2000: ");
        EmployeeDao.employeesFindBySalaryLessThan(2000).stream().forEach(System.out::println);
    }

    @Test
    void sumSalaries() {
        System.out.println("\n Sum of employee salaries");
        System.out.println(EmployeeDao.sumSalaries());
    }

    @Test
    void employeesWithSpecialCargoLicense() {
        System.out.println("\n Employees with special cargo license ");
        EmployeeDao.employeesWithSpecialCargoLicense().stream().forEach(System.out::println);
    }

    @Test
    void employeesWithCrowdLicense() {
        System.out.println("\n Employees with crowd license ");
        EmployeeDao.employeesWithCrowdLicense().stream().forEach(System.out::println);
    }
}