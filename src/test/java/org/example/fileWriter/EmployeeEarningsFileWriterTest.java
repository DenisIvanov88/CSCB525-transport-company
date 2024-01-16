package org.example.fileWriter;

import org.example.dao.EmployeeDao;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeEarningsFileWriterTest {

    @Test
    void writeEarningsToFile() {
        List<String> earningsPerEmployee = EmployeeDao.earningsPerEmployee();
        EmployeeEarningsFileWriter.writeEarningsToFile(earningsPerEmployee, "earnings_per_employee.txt");
    }
}