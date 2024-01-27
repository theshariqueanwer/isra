package com.pack.authentication.api.service;


import com.pack.authentication.api.entity.DatabaseSequence;
import com.pack.authentication.api.entity.UserDatabaseSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class UserSequenceNumberGeneratorService {

    @Autowired
    private MongoOperations mongoOperations;

    public Integer getUserSequenceNumber(String userSequenceName) {
        // get the sequence number
        Query query = new Query(Criteria.where("id").is(userSequenceName));
        // update sequence number
        Update update = new Update().inc("userSequenceNumber", 1);
        // modify in the document
        UserDatabaseSequence counter = mongoOperations
                .findAndModify(
                        query,
                        update,
                        options().returnNew(true).upsert(true),
                        UserDatabaseSequence.class
                );

        return !Objects.isNull(counter) ? counter.getUserSequenceNumber() : 1;
    }

}



// UserSequenceNumberGeneratorService