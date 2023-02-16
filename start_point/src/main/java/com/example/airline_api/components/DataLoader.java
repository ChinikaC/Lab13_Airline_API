package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.boot.ApplicationRunner;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
    }

    // Flights
//    Flight flight1 = new Flight("New York", 6, "20-02-23","5:00");
//    flightRepository.save(flight1);

    Flight montegoBayFlight = new Flight("Montego Bay", 10, "06-11-23", "18:00");

    Flight tokyoFlight = new Flight("Tokyo", 8, "22-05-23", "11:00");

    // Passengers

    Passenger passenger1 = new Passenger("Maria", "maria@gmail.com");
    Passenger passenger2 = new Passenger("Anthony", "anthony@gmail.com");
    Passenger passenger3 = new Passenger("Aaliyah", "aaliyah@gmail.com");
    Passenger passenger4 = new Passenger("Marvyn", "marvyn@gmail.com");


}
