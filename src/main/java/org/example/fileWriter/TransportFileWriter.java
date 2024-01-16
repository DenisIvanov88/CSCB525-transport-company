package org.example.fileWriter;

import org.example.entity.Transport;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TransportFileWriter {
    // Write transports information to a text file
    public static void writeTransportsToFile(List<Transport> transports, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Transport transport : transports) {
                String line = String.format("Transport ID: %d, Start Point: %s, End Point: %s, Price: %.2f, Paid: %s%n",
                        transport.getId(),
                        transport.getStartPoint(),
                        transport.getEndPoint(),
                        transport.getPrice(),
                        transport.isPaidFor() ? "Yes" : "No");
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
