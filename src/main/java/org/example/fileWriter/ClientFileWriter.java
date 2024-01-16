package org.example.fileWriter;

import org.example.entity.Client;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ClientFileWriter {
    public static void writeClientsToFile(List<Client> clients, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Client client : clients) {
                String line = String.format("Client ID: %d, Name: %s, Phone Number: %s",
                        client.getId(),
                        client.getName(),
                        client.getPhoneNumber());
                writer.write(line);

                writer.write("\n"); // Add a newline for better readability between clients
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
