package org.example.fileWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmployeeTransportFileWriter {
    public static void writeEmployeeTransportCountsToFile(List<String> employeeTransportCounts, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String line : employeeTransportCounts) {
                writer.write(line);
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
