package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Employee;
import org.example.entity.Transport;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeDao {
    //CREATE
    public static void createEmployee(Employee employee) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }
    //READ SINGLE
    public static Employee getEmployeeById(long id) {
        Employee employee;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);
            transaction.commit();
        }
        return employee;
    }
    //READ ALL
    public static List<Employee> getEmployees() {
        List<Employee> employees;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employees = session.createQuery("Select c From org.example.entity.Employee c", Employee.class).getResultList();
            transaction.commit();
        }
        return employees;
    }
    //UPDATE
    public static void updateEmployee(Employee employee) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        }
    }
    //DELETE
    public static void deleteEmployee(Employee employee) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
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

    public static long sumSalariesInCompany(long companyId) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Long> cr = cb.createQuery(Long.class);
            Root<Employee> root = cr.from(Employee.class);

            cr.select(cb.sum(root.get("salary")))
                    .where(cb.equal(root.get("company").get("id"), companyId));;

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

    public static Set<Transport> getEmployeeTransports(long id) {
        Employee employee;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            employee = session.createQuery(
                    "select c from Employee c" +
                            " join fetch c.transports" +
                            " where c.id = :id",
                    Employee.class).setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return employee.getTransports();
    }

    // READ ALL EMPLOYEES SORTED BY EARNINGS
    public static List<Employee> getEmployeesSortedByEarnings() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Fetch employees with associated transports using a LEFT JOIN FETCH
            List<Employee> employees = session.createQuery(
                            "SELECT DISTINCT e FROM Employee e LEFT JOIN FETCH e.transports", Employee.class)
                    .getResultList();

            transaction.commit();

            // Calculate total earnings for each employee based on transport prices
            Map<Employee, Double> earningsMap = employees.stream()
                    .collect(Collectors.toMap(
                            employee -> employee,
                            employee -> employee.getTransports().stream().mapToDouble(Transport::getPrice).sum()
                    ));

            // Sort employees based on total earnings in descending order
            List<Employee> sortedEmployees = earningsMap.entrySet().stream()
                    .sorted(Map.Entry.<Employee, Double>comparingByValue().reversed())
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            return sortedEmployees;
        }
    }
    public static List<String> getEmployeeTransportCounts() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            String hql = "SELECT e.id, e.name, COUNT(t.id) " +
                    "FROM Employee e " +
                    "LEFT JOIN e.transports t " +
                    "GROUP BY e.id, e.name";

            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> result = query.getResultList();

            transaction.commit();

            // Format the results as strings
            List<String> formattedResults = new ArrayList<>();
            for (Object[] row : result) {
                Long employeeId = (Long) row[0];
                String employeeName = (String) row[1];
                Long transportCount = (Long) row[2];

                String formattedResult = String.format("Employee ID: %d, Name: %s, Transport Count: %d",
                        employeeId, employeeName, transportCount);
                formattedResults.add(formattedResult);
            }

            return formattedResults;
        }
    }
}
