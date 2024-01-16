package org.example;

import org.example.configuration.SessionFactoryUtil;
import org.example.dao.*;
import org.example.entity.*;
import org.example.enums.VehicleType;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        SessionFactoryUtil.getSessionFactory().openSession();

        Company company1 = new Company("Epic Transport", "Sofia");
        Company company2 = new Company("The Transporters", "Sofia");
        CompanyDao.createCompany(company1);
        CompanyDao.createCompany(company2);

        Employee employee1 = new Employee("Ivan", "1111111111", 2500, true, true, company1);
        Employee employee2 = new Employee("Georgi", "2222222222", 2300, false, true, company1);
        Employee employee3 = new Employee("Hristo", "3333333333", 2000, false, false, company1);

        Employee employee4 = new Employee("Alex", "4444444444", 2200, false, true, company2);
        Employee employee5 = new Employee("Pesho", "5555555555", 2400, true, false, company2);
        Employee employee6 = new Employee("Mitko", "6666666666", 2600, true, true, company2);
        EmployeeDao.createEmployee(employee1);
        EmployeeDao.createEmployee(employee2);
        EmployeeDao.createEmployee(employee3);
        EmployeeDao.createEmployee(employee4);
        EmployeeDao.createEmployee(employee5);
        EmployeeDao.createEmployee(employee6);

        Vehicle vehicle1 = new Vehicle(VehicleType.DELIVERY_TRUCK.name(), "CB1111IV", 1700, company1);
        Vehicle vehicle2 = new Vehicle(VehicleType.VAN.name(), "CB2121PP", 700, company1);
        Vehicle vehicle3 = new Vehicle(VehicleType.BUS.name(), "CB1337GG", 0, company1);
        Vehicle vehicle4 = new Vehicle(VehicleType.TRAILER.name(), "CB8008QQ", 25000, company1);

        Vehicle vehicle5 = new Vehicle(VehicleType.DELIVERY_TRUCK.name(), "CB7777LU", 1600, company2);
        Vehicle vehicle6 = new Vehicle(VehicleType.DELIVERY_TRUCK.name(), "CB7474OK", 1650, company2);
        Vehicle vehicle7 = new Vehicle(VehicleType.BUS.name(), "CB2424WW", 0, company2);
        Vehicle vehicle8 = new Vehicle(VehicleType.VAN.name(), "CB8979JJ", 600, company2);
        Vehicle vehicle9 = new Vehicle(VehicleType.VAN.name(), "CB4444SH", 650, company2);
        VehicleDao.createVehicle(vehicle1);
        VehicleDao.createVehicle(vehicle2);
        VehicleDao.createVehicle(vehicle3);
        VehicleDao.createVehicle(vehicle4);
        VehicleDao.createVehicle(vehicle5);
        VehicleDao.createVehicle(vehicle6);
        VehicleDao.createVehicle(vehicle7);
        VehicleDao.createVehicle(vehicle8);
        VehicleDao.createVehicle(vehicle9);

        Client client1 = new Client("Bobby", "0888777888");
        Client client2 = new Client("Santa", "0878787878");
        Client client3 = new Client("Vacation Home Paradise", "0888555888");

        Client client4 = new Client("Vacation Home Hell", "0888666888");
        Client client5 = new Client("Sasho", "0888555888");
        Client client6 = new Client("Kaloyan", "0888555888");
        ClientDao.createClient(client1);
        ClientDao.createClient(client2);
        ClientDao.createClient(client3);
        ClientDao.createClient(client4);
        ClientDao.createClient(client5);
        ClientDao.createClient(client6);

        Transport transport1 = new Transport("Sofia airport", "Lyulin 4",
                LocalDate.of(2024, 1, 24), LocalDate.of(2024, 1, 24),
                "Wedding ring", 1, 1000, true, employee1, vehicle2, client1);
        Transport transport2 = new Transport("Lyulin 3", "Lyulin 4",
                LocalDate.of(2024, 1, 26), LocalDate.of(2024, 1, 26),
                "Alcohol", 100, 3000, true, employee2, vehicle2, client1);
        Transport transport3 = new Transport("Hippoland", "Mladost",
                LocalDate.of(2024, 1, 22), LocalDate.of(2024, 1, 22),
                "Toys", 12, 160, true, employee3, vehicle2, client2);
        Transport transport4 = new Transport("Lapland", "Sofia",
                LocalDate.of(2024, 1, 24), LocalDate.of(2024, 1, 24),
                "More toys", 10000, 100000, true, employee1, vehicle4, client2);
        Transport transport5 = new Transport("Sofia", "Burgas",
                LocalDate.of(2024, 2, 13), LocalDate.of(2024, 2, 13),
                "Tourists", 0, 1238, true, employee2, vehicle3, client3);
        Transport transport6 = new Transport("Sofia", "Paris",
                LocalDate.of(2024, 2, 13), LocalDate.of(2024, 2, 13),
                "Tourists", 0, 3763, true, employee4, vehicle7, client4);
        Transport transport7 = new Transport("Lapland", "Sofia",
                LocalDate.of(2024, 1, 19), LocalDate.of(2024, 1, 19),
                "Video card", 1, 700, false, employee5, vehicle8, client5);
        Transport transport8 = new Transport("Lapland", "Sofia",
                LocalDate.of(2024, 2, 2), LocalDate.of(2024, 2, 2),
                "Couch", 200, 1600, true, employee6, vehicle5, client6);
        TransportDao.createTransport(transport1);
        TransportDao.createTransport(transport2);
        TransportDao.createTransport(transport3);
        TransportDao.createTransport(transport4);
        TransportDao.createTransport(transport5);
        TransportDao.createTransport(transport6);
        TransportDao.createTransport(transport7);
        TransportDao.createTransport(transport8);

//        Employee employee1 = new Employee("Emp1", "111", 2000, true, true,
//                CompanyDao.getCompanyById(1));
//        Employee employee2 = new Employee("Emp2", "222", 1800, false, false,
//                CompanyDao.getCompanyById(1));
//        Employee employee3 = new Employee("Emp3", "333", 2200, true, false,
//                CompanyDao.getCompanyById(1));
//
//        EmployeeDao.createEmployee(employee1);
//        EmployeeDao.createEmployee(employee2);
//        EmployeeDao.createEmployee(employee3);

//        EmployeeDao.employeesFindBySalaryBetween(1800, 2200).stream().forEach(System.out::println);
//        EmployeeDao.employeesFindBySalaryGreaterThan(2000).stream().forEach(System.out::println);
//        EmployeeDao.employeesWithSpecialCargoLicense().stream().forEach(System.out::println);
//        EmployeeDao.employeesWithCrowdLicense().stream().forEach(System.out::println);
    }
}