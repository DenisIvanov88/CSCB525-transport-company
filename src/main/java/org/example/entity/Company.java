package org.example.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "company")
    private Set<Vehicle> vehicles;
    @OneToMany(mappedBy = "company")
    private Set<Employee> employees;
    @OneToMany(mappedBy = "company")
    private Set<Client> clients;

    //constructors
    public Company() {}
    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }

    //getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setId(long id) {
        this.id = id;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    //toString
    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
