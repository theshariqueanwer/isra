package com.pack.authentication.api.serviceimplementation;


import com.pack.authentication.api.entity.PassengerEntity;
import com.pack.authentication.api.repository.PassengerRepository;
import com.pack.authentication.api.service.PassengerSequenceNumberGeneratorService;
import com.pack.authentication.api.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PassengerServiceImplementation implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PassengerSequenceNumberGeneratorService passengerSequenceNumberGeneratorService;

    @Override
    public PassengerEntity savePassenger(PassengerEntity passengerEntity) {
        passengerEntity.setPassengerId(passengerSequenceNumberGeneratorService.getPassengerIdSequenceNumber(PassengerEntity.PASSENGER_SEQUENCE_NAME));
        passengerEntity.setPassengerSecretCode(UUID.randomUUID().toString());
        return passengerRepository.save(passengerEntity);
    }

    @Override
    public PassengerEntity postPassenger(PassengerEntity passengerEntity) {
        return passengerRepository.save(passengerEntity);
    }

    @Override
    public PassengerEntity getPassengerByPassengerId(Integer passengerId) {
        return passengerRepository.findById(passengerId).get();
    }

    @Override
    public List<PassengerEntity> getAllPassenger() {
        return passengerRepository.findAll();
    }
}
