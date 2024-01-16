package org.example.fileWriter;

import org.example.dao.TransportDao;
import org.example.entity.Transport;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransportFileWriterTest {

    @Test
    void writeTransportsToFile() {
        List<Transport> transports = TransportDao.getTransportsSortedByDestination();
        TransportFileWriter.writeTransportsToFile(transports, "transports_info.txt");
    }
}