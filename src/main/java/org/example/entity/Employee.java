package org.example.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "salary")
    private long salary;
    @Column(name = "can_transport_special_cargo")
    private boolean canTransportSpecialCargo; //flammable etc.
    @Column(name = "can_transport_crowds")
    private boolean canTransportCrowds; //12+ppl
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToMany(mappedBy = "employee")
    private Set<Transport> transports;

    //constructors
    public Employee() {}
    public Employee(String name, String phoneNumber, long salary, boolean canTransportSpecialCargo, boolean canTransportCrowds, Company company) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.canTransportSpecialCargo = canTransportSpecialCargo;
        this.canTransportCrowds = canTransportCrowds;
        this.company = company;
    }

    //getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public long getSalary() {
        return salary;
    }

    public boolean isCanTransportSpecialCargo() {
        return canTransportSpecialCargo;
    }

    public boolean isCanTransportCrowds() {
        return canTransportCrowds;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void setCanTransportSpecialCargo(boolean canTransportSpecialCargo) {
        this.canTransportSpecialCargo = canTransportSpecialCargo;
    }

    public void setCanTransportCrowds(boolean canTransportCrowds) {
        this.canTransportCrowds = canTransportCrowds;
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
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                ", canTransportSpecialCargo=" + canTransportSpecialCargo +
                ", canTransportCrowds=" + canTransportCrowds +
                ", company=" + company +
                '}';
    }
}
