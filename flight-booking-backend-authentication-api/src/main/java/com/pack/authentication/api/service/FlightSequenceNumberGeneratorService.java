package com.pack.authentication.api.service;


import com.pack.authentication.api.entity.DatabaseSequence;
import com.pack.authentication.api.entity.FlightDatabaseSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class FlightSequenceNumberGeneratorService {

    @Autowired
    private MongoOperations mongoOperations;

    public Integer getFlightIdSequenceNumber(String flightSequenceName) {
        // get the sequence number
        Query query = new Query(Criteria.where("id").is(flightSequenceName));
        // update sequence number
        Update update = new Update().inc("flightSequenceNumber", 1);
        // modify in the document
        FlightDatabaseSequence counter = mongoOperations
                .findAndModify(
                        query,
                        update,
                        options().returnNew(true).upsert(true),
                        FlightDatabaseSequence.class
                );

        return !Objects.isNull(counter) ? counter.getFlightSequenceNumber() : 1;
    }

}


// FlightSequenceNumberGeneratorService