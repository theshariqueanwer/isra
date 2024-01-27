package com.pack.authentication.api.service;


import com.pack.authentication.api.entity.PassengerDatabaseSequence;
import com.pack.authentication.api.entity.PaymentDatabaseSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class PaymentSequenceNumberGeneratorService {

    @Autowired
    private MongoOperations mongoOperations;

    public Integer getPaymentIdSequenceNumber(String paymentSequenceName) {
        // get the sequence number
        Query query = new Query(Criteria.where("id").is(paymentSequenceName));
        // update sequence number
        Update update = new Update().inc("paymentSequenceNumber", 1);
        // modify in the document
        PaymentDatabaseSequence counter = mongoOperations
                .findAndModify(
                        query,
                        update,
                        options().returnNew(true).upsert(true),
                        PaymentDatabaseSequence.class
                );

        return !Objects.isNull(counter) ? counter.getPaymentSequenceNumber() : 1;
    }

}
