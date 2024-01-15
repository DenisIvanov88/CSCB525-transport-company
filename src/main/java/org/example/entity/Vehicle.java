package org.example.entity;

import org.example.enums.VehicleType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "vehicle_type")
    private VehicleType vehicleType;
    @Column(name = "license_plate")
    private String licensePlate;
    @Column(name = "capacity_KG")
    private double capacityKG;
    @Column(name = "capacity_meters")
    private String capacityMeters; //example 3mx2m
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToMany(mappedBy = "vehicle")
    private Set<Transport> transports;

    //constructors
    public Vehicle() {}
    public Vehicle(VehicleType vehicleType, String licensePlate, double capacityKG, String capacityMeters, Company company) {
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
        this.capacityKG = capacityKG;
        this.capacityMeters = capacityMeters;
        this.company = company;
    }

    //getters
    public long getId() {
        return id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public double getCapacityKG() {
        return capacityKG;
    }

    public String getCapacityMeters() {
        return capacityMeters;
    }

    public Company getCompany() {
        return company;
    }

    public Set<Transport> getTransports() {
        return transports;
    }

    //setters
    public void setId(long id) {
        this.id = id;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setCapacityKG(double capacityKG) {
        this.capacityKG = capacityKG;
    }

    public void setCapacityMeters(String capacityMeters) {
        this.capacityMeters = capacityMeters;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setTransports(Set<Transport> transports) {
        this.transports = transports;
    }

    //toString
    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicleType=" + vehicleType +
                ", licensePlate='" + licensePlate + '\'' +
                ", capacityKG=" + capacityKG +
                ", capacityMeters='" + capacityMeters + '\'' +
                ", company=" + company +
                '}';
    }
}
