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
        EmployeeDao.deleteEmployee(EmployeeDao.getEmployeeById(7));
    }

    @Test
    void findByNameStartingWith() { //List all employees with name beginning with given string
        System.out.println("\n Name starts with Emp1: ");
        EmployeeDao.findByNameStartingWith("Emp1").stream().forEach(System.out::println);
    }

    @Test
    void employeesFindBySalaryBetween() { //List all employees with a salary between x and y
        System.out.println("\n Salary is between 1800 and 2200: ");
        EmployeeDao.employeesFindBySalaryBetween(1800, 2200).stream().forEach(System.out::println);
    }

    @Test
    void employeesFindBySalaryGreaterThan() { //List all employees with a salary more than x
        System.out.println("\n Salary is greater than 2000: ");
        EmployeeDao.employeesFindBySalaryGreaterThan(2000).stream().forEach(System.out::println);
    }

    @Test
    void employeesFindBySalaryLessThan() { //List all employees with a salary less than x
        System.out.println("\n Salary is less than 2000: ");
        EmployeeDao.employeesFindBySalaryLessThan(2000).stream().forEach(System.out::println);
    }

    @Test
    void sumSalariesInCompany() { //Sum of all salaries in a company
        System.out.println("\n Sum of employee salaries");
        System.out.println(EmployeeDao.sumSalariesInCompany(1));
    }

    @Test
    void employeesWithSpecialCargoLicense() { //List all employees with a special cargo license
        System.out.println("\n Employees with special cargo license ");
        EmployeeDao.employeesWithSpecialCargoLicense().stream().forEach(System.out::println);
    }

    @Test
    void employeesWithCrowdLicense() { //List all employees with a crowd license
        System.out.println("\n Employees with crowd license ");
        EmployeeDao.employeesWithCrowdLicense().stream().forEach(System.out::println);
    }

    @Test
    void getEmployeesSortedByEarnings() { //Employees sorted by earnings from transports
        System.out.println("\n Employees sorted by earnings from transports ");
        EmployeeDao.getEmployeesSortedByEarnings().stream().forEach(System.out::println);
    }

    @Test
    void getEmployeeTransportCounts() { //Sort employees by amount of transports
        System.out.println("\n Employees by amount of transports");
        EmployeeDao.getEmployeeTransportCounts().stream().forEach(System.out::println);
    }

    @Test
    void earningsPerEmployee() { //Calculate earnings per employee (excluding unpaid transports)
        System.out.println("\n Employees and earnings per employee");
        EmployeeDao.earningsPerEmployee().stream().forEach(System.out::println);
    }
}