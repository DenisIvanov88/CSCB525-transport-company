package org.example.fileWriter;

import org.example.entity.Vehicle;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class VehicleFileWriter {
    public static void writeVehiclesToFile(List<Vehicle> vehicles, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Vehicle vehicle : vehicles) {
                String line = String.format("Vehicle ID: %d, Type: %s, License Plate: %s, Capacity: %.2f KG, Company: %s%n",
                        vehicle.getId(),
                        vehicle.getVehicleType(),
                        vehicle.getLicensePlate(),
                        vehicle.getCapacityKG(),
                        vehicle.getCompany().getName());
                writer.write(line);

                writer.write("\n"); // Add a newline for better readability between vehicles
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
