package org.example.fileWriter;

import org.example.entity.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmployeeFileWriter {
    public static void writeEmployeesToFile(List<Employee> employees, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Employee employee : employees) {
                String line = String.format("Employee ID: %d, Name: %s, Salary: %d%n",
                        employee.getId(),
                        employee.getName(),
                        employee.getSalary());
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
