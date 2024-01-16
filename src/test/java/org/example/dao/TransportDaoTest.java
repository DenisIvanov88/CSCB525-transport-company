package org.example.dao;

import org.example.entity.Transport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TransportDaoTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void createTransport() {
        Transport transport = new Transport("Lyulin", "Mladost"
                , LocalDate.of(2024, 1, 15), LocalDate.of(2024, 1, 22)
                , "Toy", 1.5, 15, false
                , EmployeeDao.getEmployeeById(1), VehicleDao.getVehicleById(1), ClientDao.getClientById(1));
        TransportDao.createTransport(transport);
    }

    @Test
    void getTransportById() {
        System.out.println(TransportDao.getTransportById(1));
    }

    @Test
    void getTransports() {
        TransportDao.getTransports().stream().forEach(System.out::println);
    }

    @Test
    void updateTransport() {
        Transport transport = TransportDao.getTransportById(1);
        transport.setPrice(20);
        TransportDao.updateTransport(transport);
    }

    @Test
    void payForTransport() {
        Transport transport = TransportDao.getTransportById(1);
        TransportDao.payForTransport(transport);
    }

    @Test
    void deleteTransport() {
        TransportDao.deleteTransport(TransportDao.getTransportById(3));
    }

    @Test
    void getTransportsSortedByDestination() {
        TransportDao.getTransportsSortedByDestination().stream().forEach(System.out::println);
    }

    @Test
    void totalEarningInCompany() {
        System.out.println(TransportDao.totalEarningInCompany(1));;
    }

    @Test
    void totalTransportsByCompany() {
        System.out.println(TransportDao.totalTransportsByCompany(1));
    }
}