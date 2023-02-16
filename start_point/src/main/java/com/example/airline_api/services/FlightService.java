package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    // Add flights
    public List<Flight> getAllFlights(){return flightRepository.findAll();}

    // Add new flights
    public Flight addNewFlight(Flight newFlight){
        return flightRepository.save(newFlight);
    }



}
