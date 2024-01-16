package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Transport;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
