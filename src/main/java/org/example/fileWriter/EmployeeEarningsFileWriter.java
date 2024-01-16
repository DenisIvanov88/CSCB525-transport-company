package org.example.fileWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmployeeEarningsFileWriter {
    public static void writeEarningsToFile(List<String> earningsPerEmployee, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String line : earningsPerEmployee) {
                writer.write(line);
                writer.write("\n"); // Add a newline for better readability
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
