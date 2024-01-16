package org.example.fileWriter;

import org.example.dao.EmployeeDao;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTransportFileWriterTest {

    @Test
    void writeEmployeeTransportCountsToFile() {
        List<String> employeeTransportCounts = EmployeeDao.getEmployeeTransportCounts();
        EmployeeTransportFileWriter.writeEmployeeTransportCountsToFile(employeeTransportCounts, "employee_transport_counts.txt");
    }
}