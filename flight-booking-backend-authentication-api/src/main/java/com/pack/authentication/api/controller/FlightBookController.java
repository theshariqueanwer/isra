package com.pack.authentication.api.controller;


import com.pack.authentication.api.entity.FlightBookEntity;
import com.pack.authentication.api.service.FlightBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FlightBookController {

    @Autowired
    private FlightBookService flightBookService;

    @PostMapping("/flightBook")
    public FlightBookEntity flightBook(@RequestBody FlightBookEntity flightBookEntity) {
        return flightBookService.flightBook(flightBookEntity);
    }

    @PostMapping("/bookFlight")
    public FlightBookEntity bookFlight(@RequestBody FlightBookEntity flightBookEntity) {
        return flightBookService.bookFlight(flightBookEntity);
    }

    // ----------------------------------------------------------------------------------
    // need to do business logic in the service implementation

    @GetMapping("/getFlightBookByFlightBookId/{id}")
    public FlightBookEntity findByFlightBookId(@PathVariable ("id") Integer flightBookId) {
        return flightBookService.findByFlightBookId(flightBookId);
    }

    @GetMapping("/getAllFlightBook")
    public List<FlightBookEntity> getAllFlightBook() {
        return flightBookService.getAllFlightBook();
    }

}
