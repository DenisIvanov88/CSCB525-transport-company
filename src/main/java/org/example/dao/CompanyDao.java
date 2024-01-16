package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Company;
import org.example.entity.Transport;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompanyDao {
    //CREATE
    public static void createCompany(Company company) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(company);
            transaction.commit();
        }
    }
    //READ SINGLE
    public static Company getCompanyById(long id) {
        Company company;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.get(Company.class, id);
            transaction.commit();
        }
        return company;
    }
    //READ ALL
    public static List<Company> getCompanies() {
        List<Company> companies;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            companies = session.createQuery("Select c From org.example.entity.Company c", Company.class).getResultList();
            transaction.commit();
        }
        return companies;
    }
    //UPDATE
    public static void updateCompany(Company company) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(company);
            transaction.commit();
        }
    }
    //DELETE
    public static void deleteCompany(Company company) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(company);
            transaction.commit();
        }
    }

    public static List<Company> getCompaniesAlphabeticalOrder() {
        List<Company> companies;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Query<Company> query = session.createQuery("SELECT c FROM org.example.entity.Company c ORDER BY c.name", Company.class);

            companies = query.getResultList();
            transaction.commit();
        }
        return companies;
    }

    public static List<Company> getCompaniesSortedByIncome() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Fetch all companies with associated employees and transports using a LEFT JOIN FETCH
            List<Company> companies = session.createQuery(
                            "SELECT DISTINCT c FROM Company c LEFT JOIN FETCH c.employees e LEFT JOIN FETCH e.transports", Company.class)
                    .getResultList();

            transaction.commit();

            // Calculate total income for each company based on transport prices
            Map<Company, Double> incomeMap = companies.stream()
                    .collect(Collectors.toMap(
                            company -> company,
                            company -> company.getEmployees().stream().flatMap(employee -> employee.getTransports().stream())
                                    .mapToDouble(Transport::getPrice)
                                    .sum()
                    ));

            // Sort companies based on total income in descending order
            List<Company> sortedCompanies = incomeMap.entrySet().stream()
                    .sorted(Map.Entry.<Company, Double>comparingByValue().reversed())
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            return sortedCompanies;
        }
    }
}
