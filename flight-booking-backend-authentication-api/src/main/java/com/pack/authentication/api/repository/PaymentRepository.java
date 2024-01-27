package com.pack.authentication.api.repository;

import com.pack.authentication.api.entity.PaymentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface PaymentRepository extends MongoRepository<PaymentEntity, Integer> {
}
