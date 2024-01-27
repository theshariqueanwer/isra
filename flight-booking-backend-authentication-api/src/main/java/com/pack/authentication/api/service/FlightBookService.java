package com.pack.authentication.api.service;

import com.pack.authentication.api.entity.FlightBookEntity;

import java.util.List;

public interface FlightBookService {

    public FlightBookEntity flightBook(FlightBookEntity flightBookEntity);

    public FlightBookEntity bookFlight(FlightBookEntity flightBookEntity);

    public FlightBookEntity findByFlightBookId(Integer flightBookId);

    public List<FlightBookEntity> getAllFlightBook();

}
