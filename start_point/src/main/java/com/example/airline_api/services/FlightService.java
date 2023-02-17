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


    // Get all flights
    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    // Add new flights
    public Flight addNewFlight(Flight newFlight){
        return flightRepository.save(newFlight);
    }

    // Display a specific flight
    public Flight getFlightById(Long id){
        return flightRepository.findById(id).get();
    }

    // Add passenger on to flight
    public Flight addPassengerToFlight(Long flightId, Passenger passenger) {
        Flight flight = flightRepository.findById(flightId).get();
        List<Passenger> passengers = flight.getPassengers();
        passengers.add(passenger);
        flight.setPassengers(passengers);
        flightRepository.save(flight);
        return flight; }

        // Cancel a flight
        public void cancelFlight (Long id){
            flightRepository.deleteById(id);
        }

        // Filter flights by destination
    public List<Flight> findFlightByDestination(String destination){
        return flightRepository.findFlightByDestination(destination);
    }



}
