package com.pack.authentication.api.service;


import com.pack.authentication.api.entity.FlightBookDatabaseSequence;
import com.pack.authentication.api.entity.PassengerDatabaseSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class PassengerSequenceNumberGeneratorService {

    @Autowired
    private MongoOperations mongoOperations;

    public Integer getPassengerIdSequenceNumber(String passengerSequenceName) {
        // get the sequence number
        Query query = new Query(Criteria.where("id").is(passengerSequenceName));
        // update sequence number
        Update update = new Update().inc("passengerSequenceNumber", 1);
        // modify in the document
        PassengerDatabaseSequence counter = mongoOperations
                .findAndModify(
                        query,
                        update,
                        options().returnNew(true).upsert(true),
                        PassengerDatabaseSequence.class
                );

        return !Objects.isNull(counter) ? counter.getPassengerSequenceNumber() : 1;
    }



}
