package org.example.dao;

import org.example.entity.Client;
import org.example.entity.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientDaoTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void createClient() {
        Client client = new Client("Ivan", "8888888888");
        ClientDao.createClient(client);
    }

    @Test
    void getClientById() {
        System.out.println(ClientDao.getClientById(1));
    }

    @Test
    void getClients() {
        ClientDao.getClients().stream().forEach(System.out::println);
    }

    @Test
    void updateClient() {
        Client client = ClientDao.getClientById(1);
        client.setName("Bobby");
        ClientDao.updateClient(client);
    }

    @Test
    void deleteClient() {
        ClientDao.deleteClient(ClientDao.getClientById(7));
    }
}