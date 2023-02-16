package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Passengers
        Passenger passenger1 = new Passenger("Maria", "maria@gmail.com");
        passengerRepository.save(passenger1);

        Passenger passenger2 = new Passenger("Anthony", "anthony@gmail.com");
        passengerRepository.save(passenger2);

        Passenger passenger3 = new Passenger("Aaliyah", "aaliyah@gmail.com");
        passengerRepository.save(passenger3);

        Passenger passenger4 = new Passenger("Marvyn", "marvyn@gmail.com");
        passengerRepository.save(passenger4);

        Passenger passenger5 = new Passenger("Mary", "mary@gmail.com");
        passengerRepository.save(passenger5);

        Passenger passenger6 = new Passenger("Sophie", "sophie@gmail.com");
        passengerRepository.save(passenger6);


        //Flights
        Flight flight1 = new Flight("New York", 150, "22-02-2023", "05:00");
        flight1.addPassenger(passenger1);
        flightRepository.save(flight1);

        Flight flight2 = new Flight("Montego Bay", 150, "07-11-2023", "13:30");
        flight2.addPassenger(passenger1);
        flightRepository.save(flight2);

        Flight flight3 = new Flight("Tokyo", 200, "18-04-2023", "18:45");
        flight3.addPassenger(passenger2);
        flightRepository.save(flight3);

        Flight flight4 = new Flight("Dubai", 200, "14-12-2023", "04:00");
        flight4.addPassenger(passenger2);
        flightRepository.save(flight4);

        Flight flight5 = new Flight("Marrakesh", 150, "11-09-2023", "19:30");
        flight5.addPassenger(passenger3);
        flightRepository.save(flight5);

        Flight flight6 = new Flight("Sydney", 150, "06-06-2023", "09:45");
        flight6.addPassenger(passenger3);
        flightRepository.save(flight6);

        Flight flight7 = new Flight("Cape Town", 200, "31-05-2023", "00:00");
        flight7.addPassenger(passenger4);
        flightRepository.save(flight7);

        Flight flight8 = new Flight("Paris", 200, "10-04-2023", "14:30");
        flight8.addPassenger(passenger4);
        flightRepository.save(flight8);

        Flight flight9 = new Flight("Istanbul", 150, "09-10-2023", "17:45");
        flight9.addPassenger(passenger5);
        flightRepository.save(flight9);

        Flight flight10 = new Flight("Madrid", 150, "14-09-2023", "07:00");
        flight10.addPassenger(passenger5);
        flightRepository.save(flight10);

        Flight flight11 = new Flight("Amsterdam", 200, "08-08-2023", "15:30");
        flight7.addPassenger(passenger6);
        flightRepository.save(flight11);

        Flight flight12 = new Flight("Chiang Mai", 200, "22-11-2023", "02:45");
        flight12.addPassenger(passenger6);
        flightRepository.save(flight12);
    }
}
