package org.example.dao;

import org.example.entity.Company;
import org.example.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void createEmployee() {
        Employee employee = new Employee("Hristo", "1111111111", 2000, false, true, CompanyDao.getCompanyById(1));
        EmployeeDao.createEmployee(employee);
    }

    @Test
    void getEmployeeById() {
        System.out.println(EmployeeDao.getEmployeeById(4));
    }

    @Test
    void getEmployees() {
        EmployeeDao.getEmployees().stream().forEach(System.out::println);
    }

    @Test
    void updateEmployee() {
        Employee employee = EmployeeDao.getEmployeeById(4);
        employee.setName("Georgi");
        EmployeeDao.updateEmployee(employee);
    }

    @Test
    void deleteEmployee() {
        EmployeeDao.deleteEmployee(EmployeeDao.getEmployeeById(4));
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
    void sumSalariesInCompany() {
        System.out.println("\n Sum of employee salaries");
        System.out.println(EmployeeDao.sumSalariesInCompany(1));
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

    @Test
    void getEmployeeTransports() {
        System.out.println("\n Get all transports of employee");
        EmployeeDao.getEmployeeTransports(1).stream().forEach(System.out::println);
    }

    @Test
    void getEmployeesSortedByEarnings() {
        EmployeeDao.getEmployeesSortedByEarnings().stream().forEach(System.out::println);
    }

    @Test
    void getEmployeeTransportCounts() {
        EmployeeDao.getEmployeeTransportCounts().stream().forEach(System.out::println);
    }
}