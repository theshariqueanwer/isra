package com.pack.authentication.api.service;

import com.pack.authentication.api.entity.FlightBookDatabaseSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class FlightBookSequenceNumberGeneratorService {

    @Autowired
    private MongoOperations mongoOperations;

    public Integer getFlightBookIdSequenceNumber(String flightBookSequenceName) {
        // get the sequence number
        Query query = new Query(Criteria.where("id").is(flightBookSequenceName));
        // update sequence number
        Update update = new Update().inc("flightBookSequenceNumber", 1);
        // modify in the document
        FlightBookDatabaseSequence counter = mongoOperations
                .findAndModify(
                        query,
                        update,
                        options().returnNew(true).upsert(true),
                        FlightBookDatabaseSequence.class
                );

        return !Objects.isNull(counter) ? counter.getFlightBookSequenceNumber() : 1;
    }

}
