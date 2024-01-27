package com.pack.authentication.api.repository;

import com.pack.authentication.api.entity.PassengerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableMongoRepositories
public interface PassengerRepository extends MongoRepository<PassengerEntity, Integer> {
}
