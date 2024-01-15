package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeDao {

    public static void createEmployee(Employee employee) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    public static Employee getEmployeeById(long id) {
        Employee employee;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);
            transaction.commit();
        }
        return employee;
    }

    public static List<Employee> findByNameStartingWith(String name) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
            Root<Employee> root = cr.from(Employee.class);

            cr.select(root).where(cb.like(root.get("name"), name + "%"));

            Query<Employee> query = session.createQuery(cr);
            return query.getResultList();
        }
    }

    public static List<Employee> employeesFindBySalaryBetween(double bottom, double top) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
            Root<Employee> root = cr.from(Employee.class);

            cr.select(root).where(cb.between(root.get("salary"), bottom, top));

            Query<Employee> query = session.createQuery(cr);
            return query.getResultList();
        }
    }

    public static List<Employee> employeesFindBySalaryGreaterThan(double amount) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
            Root<Employee> root = cr.from(Employee.class);

            cr.select(root).where(cb.greaterThan(root.get("salary"), amount));

            Query<Employee> query = session.createQuery(cr);
            return query.getResultList();
        }
    }

    public static List<Employee> employeesFindBySalaryLessThan(double amount) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
            Root<Employee> root = cr.from(Employee.class);

            cr.select(root).where(cb.lessThan(root.get("salary"), amount));

            Query<Employee> query = session.createQuery(cr);
            return query.getResultList();
        }
    }

    public static long sumSalaries() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Long> cr = cb.createQuery(Long.class);
            Root<Employee> root = cr.from(Employee.class);

            cr.select(cb.sum(root.get("salary")));

            Query<Long> query = session.createQuery(cr);
            return query.getSingleResult();
        }
    }

    public static List<Employee> employeesWithSpecialCargoLicense() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
            Root<Employee> root = cr.from(Employee.class);

            cr.select(root).where(cb.isTrue(root.get("canTransportSpecialCargo")));

            Query<Employee> query = session.createQuery(cr);
            return query.getResultList();
        }
    }

    public static List<Employee> employeesWithCrowdLicense() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
            Root<Employee> root = cr.from(Employee.class);

            cr.select(root).where(cb.isTrue(root.get("canTransportCrowds")));

            Query<Employee> query = session.createQuery(cr);
            return query.getResultList();
        }
    }
}
