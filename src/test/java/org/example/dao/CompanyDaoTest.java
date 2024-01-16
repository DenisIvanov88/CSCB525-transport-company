package org.example.dao;

import org.example.entity.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyDaoTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void createCompany() {
        Company company = new Company("Comp2", "Address2");
        CompanyDao.createCompany(company);
    }

    @Test
    void getCompanyById() {
        System.out.println(CompanyDao.getCompanyById(2));
    }

    @Test
    void getCompanies() {
        CompanyDao.getCompanies().stream().forEach(System.out::println);
    }

    @Test
    void updateCompany() {
        Company company = CompanyDao.getCompanyById(4);
        company.setName("Company4");
        CompanyDao.updateCompany(company);
    }

    @Test
    void deleteCompany() {
        CompanyDao.deleteCompany(CompanyDao.getCompanyById(3));
    }

    @Test
    void getCompaniesAlphabeticalOrder() {
        CompanyDao.getCompaniesAlphabeticalOrder().stream().forEach(System.out::println);
    }

    @Test
    void getCompaniesSortedByIncome() {
        CompanyDao.getCompaniesSortedByIncome().stream().forEach(System.out::println);
    }
}