package org.example.fileWriter;

import org.example.dao.EmployeeDao;
import org.example.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFileWriterTest {

    @Test
    void writeEmployeesToFile() {
        List<Employee> employees = EmployeeDao.getEmployees();
        EmployeeFileWriter.writeEmployeesToFile(employees, "employees_info.txt");
    }
}