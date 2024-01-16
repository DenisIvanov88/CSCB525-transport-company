package org.example.fileWriter;

import org.example.entity.Company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CompanyFileWriter {
    public static void writeCompaniesToFile(List<Company> companies, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Company company : companies) {
                String line = String.format("Company ID: %d, Name: %s, Address: %s%n",
                        company.getId(),
                        company.getName(),
                        company.getAddress());
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
