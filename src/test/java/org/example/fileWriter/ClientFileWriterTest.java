package org.example.fileWriter;

import org.example.dao.ClientDao;
import org.example.entity.Client;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientFileWriterTest {

    @Test
    void writeClientsToFile() {
        List<Client> clients = ClientDao.getClients();
        ClientFileWriter.writeClientsToFile(clients, "clients_info.txt");
    }
}