package org.example.fileWriter;

import org.example.dao.VehicleDao;
import org.example.entity.Vehicle;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleFileWriterTest {

    @Test
    void writeVehiclesToFile() {
        List<Vehicle> vehicles = VehicleDao.getVehicles();
        VehicleFileWriter.writeVehiclesToFile(vehicles, "vehicles_info.txt");
    }
}