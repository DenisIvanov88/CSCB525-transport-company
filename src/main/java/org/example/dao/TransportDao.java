package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Transport;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TransportDao {
    //CREATE
    public static void createTransport(Transport transport) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(transport);
            transaction.commit();
        }
    }
    //READ SINGLE
    public static Transport getTransportById(long id) {
        Transport transport;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            transport = session.get(Transport.class, id);
            transaction.commit();
        }
        return transport;
    }
    //READ ALL
    public static List<Transport> getTransports() {
        List<Transport> transports;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            transports = session.createQuery("Select c From org.example.entity.Transport c", Transport.class).getResultList();
            transaction.commit();
        }
        return transports;
    }
    //UPDATE
    public static void updateTransport(Transport transport) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(transport);
            transaction.commit();
        }
    }
    //UPDATE PAID STATUS TO TRUE
    public static void payForTransport(Transport transport) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            transport.setPaidFor(true);
            session.saveOrUpdate(transport);
            transaction.commit();
        }
    }
    //DELETE
    public static void deleteTransport(Transport transport) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(transport);
            transaction.commit();
        }
    }

    // READ ALL TRANSPORTS SORTED BY DESTINATION
    public static List<Transport> getTransportsSortedByDestination() {
        List<Transport> transports;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Use HQL (Hibernate Query Language) with ORDER BY clause to retrieve transports sorted by destination
            transports = session.createQuery("SELECT t FROM org.example.entity.Transport t ORDER BY t.endPoint", Transport.class)
                    .getResultList();

            transaction.commit();
        }
        return transports;
    }

    // Calculate total earnings in a company by id
    public static double totalEarningInCompany(long companyId) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            String hql = "SELECT COALESCE(SUM(t.price), 0.0) " +
                    "FROM Transport t " +
                    "JOIN t.employee e " +
                    "JOIN e.company c " +
                    "WHERE c.id = :companyId";

            Query<Double> query = session.createQuery(hql, Double.class);
            query.setParameter("companyId", companyId);
            Double totalEarnings = query.uniqueResult();

            transaction.commit();

            return totalEarnings != null ? totalEarnings : 0.0;
        }
    }

    // Calculate total transports done by a company by id
    public static long totalTransportsByCompany(long companyId) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            String hql = "SELECT COUNT(t.id) " +
                    "FROM Transport t " +
                    "JOIN t.employee e " +
                    "JOIN e.company c " +
                    "WHERE c.id = :companyId";

            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("companyId", companyId);
            Long totalTransports = query.uniqueResult();

            transaction.commit();

            return totalTransports != null ? totalTransports : 0L;
        }
    }
}
