package com.pack.authentication.api.controller;


import com.pack.authentication.api.entity.FlightEntity;
import com.pack.authentication.api.model.*;
import com.pack.authentication.api.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FlightController {


    @Autowired
    private FlightService flightService;

    @PostMapping("/saveFlight")
    public FlightEntity saveFlight(@RequestBody FlightEntity flightEntity) {
        return flightService.saveFlight(flightEntity);
    }

    // ----------------------------------------------------------------------------------
    // need to do business logic in the service implementation

    @GetMapping("/getFlightByFlightId/{id}")
    public FlightEntity getFlightByFlightId(@PathVariable("id") Integer flightId) {
        return flightService.getFlightByFlightId(flightId);
    }

    @GetMapping("/getAllFlight")
    public List<FlightEntity> getAllFlight() {
        return flightService.getAllFlight();
    }

    // ==================================================================================

    @PostMapping("/searchFlightByFromAndToAndDate")
    public List<FlightEntity> findByFlightFromAndFlightToAndFlightDate(@RequestBody FlightSearchRequest flightSearchRequest) {
        return flightService.findByFlightFromAndFlightToAndFlightDate(flightSearchRequest);
    }

    // ----------------------------------------------------------------------------------
    // need to do business logic in the service implementation





}
