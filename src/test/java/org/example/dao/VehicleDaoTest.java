package org.example.dao;

import org.example.entity.Vehicle;
import org.example.enums.VehicleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleDaoTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void createVehicle() {
        Vehicle vehicle = new Vehicle(VehicleType.DELIVERY_TRUCK.name().toString(), "CB1111WW" , 1500, CompanyDao.getCompanyById(1));
        VehicleDao.createVehicle(vehicle);
    }

    @Test
    void getVehicleById() {
        System.out.println(VehicleDao.getVehicleById(2));
    }

    @Test
    void getVehicleByLicensePlate() {
        System.out.println(VehicleDao.getVehicleByLicensePlate("CB1111IV"));
    }

    @Test
    void getVehicles() {
        VehicleDao.getVehicles().stream().forEach(System.out::println);
    }

    @Test
    void updateVehicle() {
        Vehicle vehicle = VehicleDao.getVehicleById(1);
        vehicle.setVehicleType(VehicleType.DELIVERY_TRUCK.name());
        VehicleDao.updateVehicle(vehicle);
    }

    @Test
    void deleteVehicle() {
        VehicleDao.deleteVehicle(VehicleDao.getVehicleById(10));
    }
}