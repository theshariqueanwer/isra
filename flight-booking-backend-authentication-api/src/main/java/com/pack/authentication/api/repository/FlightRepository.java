package com.pack.authentication.api.repository;

import com.pack.authentication.api.entity.FlightEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
@EnableMongoRepositories
public interface FlightRepository extends MongoRepository<FlightEntity, Integer> {

    public List<FlightEntity> findByFlightFromAndFlightToAndFlightDate(String flightFrom, String flightTo, String flightDate);

}
