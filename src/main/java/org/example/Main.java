package org.example;

import org.example.configuration.SessionFactoryUtil;
import org.example.dao.CompanyDao;
import org.example.dao.EmployeeDao;
import org.example.entity.Company;
import org.example.entity.Employee;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        SessionFactoryUtil.getSessionFactory().openSession();

//        Employee employee1 = new Employee("Emp1", "111", 2000, true, true,
//                CompanyDao.getCompanyById(1));
//        Employee employee2 = new Employee("Emp2", "222", 1800, false, false,
//                CompanyDao.getCompanyById(1));
//        Employee employee3 = new Employee("Emp3", "333", 2200, true, false,
//                CompanyDao.getCompanyById(1));
//
//        EmployeeDao.createEmployee(employee1);
//        EmployeeDao.createEmployee(employee2);
//        EmployeeDao.createEmployee(employee3);

//        EmployeeDao.employeesFindBySalaryBetween(1800, 2200).stream().forEach(System.out::println);
//        EmployeeDao.employeesFindBySalaryGreaterThan(2000).stream().forEach(System.out::println);
//        EmployeeDao.employeesWithSpecialCargoLicense().stream().forEach(System.out::println);
//        EmployeeDao.employeesWithCrowdLicense().stream().forEach(System.out::println);
    }
}