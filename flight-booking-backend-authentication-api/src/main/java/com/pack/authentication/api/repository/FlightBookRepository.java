package com.pack.authentication.api.repository;

import com.pack.authentication.api.entity.FlightBookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface FlightBookRepository extends MongoRepository<FlightBookEntity, Integer> {
}
