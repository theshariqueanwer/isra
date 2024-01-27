package com.pack.authentication.api.controller;


import com.pack.authentication.api.entity.PassengerEntity;
import com.pack.authentication.api.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping("/savePassenger")
    public ResponseEntity<PassengerEntity> savePassenger(@RequestBody PassengerEntity passengerEntity) {
        PassengerEntity passenger = passengerService.savePassenger(passengerEntity);
        return new ResponseEntity<PassengerEntity>(passenger, HttpStatus.OK);
    }

    @PostMapping("/postPassenger")
    public PassengerEntity postPassenger(@RequestBody PassengerEntity passengerEntity) {
        return passengerService.postPassenger(passengerEntity);
    }

    @GetMapping("/getPassengerByPassengerId/{id}")
    public PassengerEntity getPassengerByPassengerId(@PathVariable ("id") Integer passengerId) {
        return passengerService.getPassengerByPassengerId(passengerId);
    }

    @GetMapping("/getAllPassenger")
    public List<PassengerEntity> getAllPassenger() {
        return passengerService.getAllPassenger();
    }

}
