package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

     // Display all available flights and filter by destination
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlightsAndFilterByDestination(
            @RequestParam(required = false, name = "destination") String destination) {
        // Filter by destination:
        List<Flight> flights;
        if (destination != null) {
            return new ResponseEntity<>(flightService.findFlightByDestination(destination), HttpStatus.OK);
        }
            // Get all flights:
            return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
        }

        // Display a specific flight
        @GetMapping(value = "/{id}")
        public ResponseEntity<Flight> getFlightById (@PathVariable Long id){
            Flight findflight = flightService.getFlightById(id);
            return new ResponseEntity<>(findflight, HttpStatus.OK);
        }

        // Add details of a new flight
        @PostMapping
        public ResponseEntity<Flight> addNewFlight (@RequestBody Flight flight){
            flightService.addNewFlight(flight);
            return new ResponseEntity<>(flight, HttpStatus.CREATED);
        }

        // Book a passenger on to a flight
        @PatchMapping(value = "/{id}")
        public ResponseEntity<Flight> addPassengerToFlight (@RequestBody Passenger passenger, @PathVariable Long id){
                Flight flight = flightService.addPassengerToFlight(id, passenger);
            return new ResponseEntity<>(flight, HttpStatus.OK);
        }

        // Cancel a flight
        @DeleteMapping(value = "/{id}")
        public ResponseEntity cancelFlight (@PathVariable Long id){
            flightService.cancelFlight(id);
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        }


    }
