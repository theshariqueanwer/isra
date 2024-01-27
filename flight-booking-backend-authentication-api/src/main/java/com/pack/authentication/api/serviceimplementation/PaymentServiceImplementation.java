package com.pack.authentication.api.serviceimplementation;

import com.pack.authentication.api.entity.PaymentEntity;
import com.pack.authentication.api.repository.PaymentRepository;
import com.pack.authentication.api.service.PaymentSequenceNumberGeneratorService;
import com.pack.authentication.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentServiceImplementation implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentSequenceNumberGeneratorService paymentSequenceNumberGeneratorService;

    public String getTransactionID() {
        long number = (long) (Math.random() * 10000L);
        String transactionID = "transactionId" + 10000L + number;
        return transactionID;
    }

    public String getCardNumber() {
        long first14 = (long) (Math.random() * 10000000000000L);
        long first16 =  4200000000000000L + first14;
        String number = "" + first16;
        return number;
    }

    public String getCurrentTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String getTime = formatter.format(date);
        return getTime;
    }

    @Override
    public PaymentEntity savePayment(PaymentEntity paymentEntity) {

        paymentEntity.setPaymentId(paymentSequenceNumberGeneratorService.getPaymentIdSequenceNumber(PaymentEntity.PAYMENT_SEQUENCE_NAME));

        // paymentType will be manually

        // paymentTypeMethod will be manually

        // paymentMethodDetails will be manually

        paymentEntity.setPaymentMethodDetails(getCardNumber());

        // FlightFare we be manually

        paymentEntity.setTransactionID(getTransactionID());

        paymentEntity.setUniqueID(UUID.randomUUID().toString());

        paymentEntity.setTransactionDate(getCurrentTime());

        // flightBookingId will come here manually

        return paymentRepository.save(paymentEntity);
    }

    @Override
    public PaymentEntity postPayment(PaymentEntity paymentEntity) {

        paymentEntity.setPaymentId(paymentSequenceNumberGeneratorService.getPaymentIdSequenceNumber(PaymentEntity.PAYMENT_SEQUENCE_NAME));

        // paymentType will be manually

        // paymentTypeMethod will be manually

        // paymentMethodDetails will be manually

        paymentEntity.setPaymentMethodDetails(getCardNumber());

        // FlightFare we be manually

        paymentEntity.setTransactionID(getTransactionID());

        paymentEntity.setUniqueID(UUID.randomUUID().toString());

        paymentEntity.setTransactionDate(getCurrentTime());

        // flightBookingId will come here manually

        return paymentRepository.save(paymentEntity);
    }

    @Override
    public PaymentEntity getPaymentByPaymentId(Integer paymentId) {
        return paymentRepository.findById(paymentId).get();
    }

    @Override
    public List<PaymentEntity> getAllPayment() {
        return paymentRepository.findAll();
    }
}


// FlightEntity flight = new FlightEntity();
// flight = flightRepository.findById(flight.getFlightId()).get();
