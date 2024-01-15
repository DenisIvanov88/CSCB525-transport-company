package org.example.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transport")
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "start_point")
    private String startPoint;
    @Column(name = "end_point")
    private String endPoint;
    @Column(name = "departure_date")
    private LocalDate departureDate;
    @Column(name = "arrival_date")
    private LocalDate arrivalDate;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "weight")
    private double weight;
    @Column(name = "price")
    private double price;
    @Column(name = "is_paid_for")
    private boolean isPaidFor;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee; //transported by employee
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle; //transported by vehicle
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client; //issued by client

    //constructors
    public Transport() {}
    public Transport(String startPoint, String endPoint, LocalDate departureDate, LocalDate arrivalDate, String cargo,
                     double weight, double price, boolean isPaidFor, Employee employee, Vehicle vehicle, Client client) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.cargo = cargo;
        this.weight = weight;
        this.price = price;
        this.isPaidFor = isPaidFor;
        this.employee = employee;
        this.vehicle = vehicle;
        this.client = client;
    }

    //getters
    public long getId() {
        return id;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public String getCargo() {
        return cargo;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPaidFor() {
        return isPaidFor;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Client getClient() {
        return client;
    }

    //setters
    public void setId(long id) {
        this.id = id;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPaidFor(boolean paidFor) {
        isPaidFor = paidFor;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    //toString
    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", startPoint='" + startPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", cargo='" + cargo + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", isPaidFor=" + isPaidFor +
                ", employee=" + employee +
                ", vehicle=" + vehicle +
                ", client=" + client +
                '}';
    }
}
