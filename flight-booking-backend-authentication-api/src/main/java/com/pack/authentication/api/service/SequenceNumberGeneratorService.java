package com.pack.authentication.api.service;


import com.pack.authentication.api.entity.DatabaseSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceNumberGeneratorService {

    @Autowired
    private MongoOperations mongoOperations;

    public Integer getSequenceNumber(String sequenceName) {
        // get the sequence number
        Query query = new Query(Criteria.where("id").is(sequenceName));
        // update sequence number
        Update update = new Update().inc("sequenceNumber", 1);
        // modify in the document
        DatabaseSequence counter = mongoOperations
                .findAndModify(
                        query,
                        update,
                        options().returnNew(true).upsert(true),
                        DatabaseSequence.class
                );

        return !Objects.isNull(counter) ? counter.getSequenceNumber() : 1;
    }

}
