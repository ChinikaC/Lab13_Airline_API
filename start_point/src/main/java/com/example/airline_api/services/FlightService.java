package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;


    // Get all flights
    public List<Flight> getAllFlights(){return flightRepository.findAll();}

    // Add new flights
    public Flight addNewFlight(Flight newFlight){
        return flightRepository.save(newFlight);
    }

    // Display a specific flight
    public Flight getFlightById(long id){
        return flightRepository.findById(id).get();
    }

    // Add passenger to flight
    public Flight addPassengerToFlight(long flightId, Passenger passenger){
        Flight flight = flightRepository.findById(flightId).get();
        List<Passenger> passengers = flight.getPassengers();
        passengers.add(passenger);
        flight.setPassengers(passengers);
        flightRepository.save(flight);
        return flight;
    }

     // Cancel flight
    public void cancelFlight(Long id){
        flightRepository.deleteById(id);
    }

    // Prevent passenger from being booked on a flight that is full
    public boolean canPassengerGetBookedOntoFlight(Flight flight){
        if(flight.getCapacity() >= 200){
            return false;
        } else {
            return true;
        }
    }




}
