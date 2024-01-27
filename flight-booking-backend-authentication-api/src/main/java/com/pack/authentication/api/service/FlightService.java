package com.pack.authentication.api.service;

import com.pack.authentication.api.entity.FlightEntity;
import com.pack.authentication.api.model.*;

import java.util.List;

public interface FlightService {

    public FlightEntity saveFlight(FlightEntity flightEntity);

    public FlightEntity getFlightByFlightId(Integer flightId);

    public List<FlightEntity> getAllFlight();

    // ================================================================================================

    public List<FlightEntity> findByFlightFromAndFlightToAndFlightDate(FlightSearchRequest flightSearchRequest);


}

