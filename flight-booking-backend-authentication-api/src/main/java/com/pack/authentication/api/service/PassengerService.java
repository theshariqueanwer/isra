package com.pack.authentication.api.service;


import com.pack.authentication.api.entity.PassengerEntity;

import java.util.List;

public interface PassengerService {

    public PassengerEntity savePassenger(PassengerEntity passengerEntity);

    public PassengerEntity postPassenger(PassengerEntity passengerEntity);

    public PassengerEntity getPassengerByPassengerId(Integer passengerId);

    public List<PassengerEntity> getAllPassenger();

}
