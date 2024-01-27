package com.pack.authentication.api.serviceimplementation;

import com.pack.authentication.api.entity.*;
import com.pack.authentication.api.model.UserEntityRequest;
import com.pack.authentication.api.repository.*;
import com.pack.authentication.api.service.FlightBookSequenceNumberGeneratorService;
import com.pack.authentication.api.service.FlightBookService;
import com.pack.authentication.api.service.PassengerSequenceNumberGeneratorService;
import com.pack.authentication.api.service.PaymentSequenceNumberGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FlightBookServiceImplementation implements FlightBookService {

    @Autowired
    private FlightBookRepository flightBookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private FlightBookSequenceNumberGeneratorService flightBookSequenceNumberGeneratorService;

    @Autowired
    private PassengerSequenceNumberGeneratorService passengerSequenceNumberGeneratorService;

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

    public String getCurrentDateAndTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String getDateAndTime = formatter.format(date);
        return getDateAndTime;
    }

    public String getFlightBookingNumber() {
        Integer number = (int)(Math.random() * 100000);
        number = 10000000 + number;
        System.out.println(number);
        String flightBookingNumber = "flight" + number;
        return flightBookingNumber;
    }


    @Override
    public FlightBookEntity flightBook(FlightBookEntity flightBookEntity) {

        flightBookEntity.setFlightBookingId(flightBookSequenceNumberGeneratorService.getFlightBookIdSequenceNumber(FlightBookEntity.FLIGHT_BOOK_SEQUENCE_NAME));
        flightBookEntity.setFlightBookingNumber(getFlightBookingNumber());

        UserEntity user = userRepository.findById(flightBookEntity.getUserEntityRequest().getUserId()).get();
        FlightEntity flight = flightRepository.findById(flightBookEntity.getFlightEntity().getFlightId()).get();

        UserEntityRequest userEntityRequest = new UserEntityRequest();
        userEntityRequest.setUserId(user.getUserId());
        userEntityRequest.setUserFullName(user.getUserFullName());
        userEntityRequest.setUserName(user.getUserName());
        userEntityRequest.setEmail(user.getEmail());
        userEntityRequest.setMobile(user.getMobile());

        flightBookEntity.setUserEntityRequest(userEntityRequest);
        flightBookEntity.setFlightEntity(flight);
        // ----------------------------------------------------------------------------------------
        PassengerEntity passenger = new PassengerEntity();

        passenger.setPassengerId(passengerSequenceNumberGeneratorService.getPassengerIdSequenceNumber(PassengerEntity.PASSENGER_SEQUENCE_NAME));
        passenger.setPassengerFullName(flightBookEntity.getPassengerEntity().getPassengerFullName());
        passenger.setPassengerEmail(flightBookEntity.getPassengerEntity().getPassengerEmail());
        passenger.setPassengerMobile(flightBookEntity.getPassengerEntity().getPassengerMobile());
        passenger.setPassengerGender(flightBookEntity.getPassengerEntity().getPassengerGender());
        passenger.setPassengerDateOfBirth(flightBookEntity.getPassengerEntity().getPassengerDateOfBirth());
        passenger.setPassengerAddress(flightBookEntity.getPassengerEntity().getPassengerAddress());
        passenger.setPassengerSecretCode(UUID.randomUUID().toString());
        passengerRepository.save(passenger);

        flightBookEntity.setPassengerEntity(passenger);
        // ----------------------------------------------------------------------------------------
        PaymentEntity payment = new PaymentEntity();

        payment.setPaymentId(paymentSequenceNumberGeneratorService.getPaymentIdSequenceNumber(PaymentEntity.PAYMENT_SEQUENCE_NAME));
        payment.setPaymentType(flightBookEntity.getPaymentEntity().getPaymentType());
        payment.setPaymentTypeMethod(flightBookEntity.getPaymentEntity().getPaymentTypeMethod());
//        payment.setPaymentMethodDetails(getCardNumber());
        payment.setPaymentMethodDetails(flightBookEntity.getPaymentEntity().getPaymentMethodDetails());
        payment.setAmount(flight.getFlightFare());
        payment.setTransactionID(getTransactionID());
        payment.setUniqueID(UUID.randomUUID().toString());
        payment.setTransactionDate(getCurrentDateAndTime());
        paymentRepository.save(payment);

        flightBookEntity.setPaymentEntity(payment);
        // ----------------------------------------------------------------------------------------

        flightBookEntity.setFlightBookingSecretCode(UUID.randomUUID().toString());
        flightBookEntity.setFlightBookingStatus("confirmed");
        flightBookEntity.setFlightBookingDate(getCurrentDateAndTime());

        flightBookRepository.save(flightBookEntity);

        passenger.setFlightBookingId(flightBookEntity.getFlightBookingId());
        passengerRepository.save(passenger);
        flightBookEntity.setPassengerEntity(passenger);

        payment.setFlightBookingId(flightBookEntity.getFlightBookingId());
        paymentRepository.save(payment);
        flightBookEntity.setPaymentEntity(payment);

        flightBookRepository.save(flightBookEntity);
        return flightBookEntity;
    }


    // --------------------------------------------------------------------------------
    // need to do business logic in the service implementation


    @Override
    public FlightBookEntity bookFlight(FlightBookEntity flightBookEntity) {

        flightBookEntity.setFlightBookingId(flightBookSequenceNumberGeneratorService.getFlightBookIdSequenceNumber(FlightBookEntity.FLIGHT_BOOK_SEQUENCE_NAME));
        flightBookEntity.setFlightBookingNumber(getFlightBookingNumber());

        UserEntity user = userRepository.findById(flightBookEntity.getUserEntityRequest().getUserId()).get();

        FlightEntity flight = flightRepository.findById(flightBookEntity.getFlightEntity().getFlightId()).get();

        UserEntityRequest userEntityRequest = new UserEntityRequest();
        userEntityRequest.setUserId(user.getUserId());
        userEntityRequest.setUserFullName(user.getUserFullName());
        userEntityRequest.setUserName(user.getUserName());
        userEntityRequest.setEmail(user.getEmail());
        userEntityRequest.setMobile(user.getMobile());

        flightBookEntity.setUserEntityRequest(userEntityRequest);
        flightBookEntity.setFlightEntity(flight);
        // ----------------------------------------------------------------------------------------
        PassengerEntity passenger = new PassengerEntity();

        passenger.setPassengerId(passengerSequenceNumberGeneratorService.getPassengerIdSequenceNumber(PassengerEntity.PASSENGER_SEQUENCE_NAME));
        passenger.setPassengerFullName(flightBookEntity.getPassengerEntity().getPassengerFullName());
        passenger.setPassengerEmail(flightBookEntity.getPassengerEntity().getPassengerEmail());
        passenger.setPassengerMobile(flightBookEntity.getPassengerEntity().getPassengerMobile());
        passenger.setPassengerGender(flightBookEntity.getPassengerEntity().getPassengerGender());
        passenger.setPassengerDateOfBirth(flightBookEntity.getPassengerEntity().getPassengerDateOfBirth());
        passenger.setPassengerAddress(flightBookEntity.getPassengerEntity().getPassengerAddress());
        passenger.setPassengerSecretCode(UUID.randomUUID().toString());
        passengerRepository.save(passenger);

        flightBookEntity.setPassengerEntity(passenger);
        // ----------------------------------------------------------------------------------------
        PaymentEntity payment = new PaymentEntity();

        payment.setPaymentId(paymentSequenceNumberGeneratorService.getPaymentIdSequenceNumber(PaymentEntity.PAYMENT_SEQUENCE_NAME));
        payment.setPaymentType(flightBookEntity.getPaymentEntity().getPaymentType());
        payment.setPaymentTypeMethod(flightBookEntity.getPaymentEntity().getPaymentTypeMethod());
        payment.setPaymentMethodDetails(getCardNumber());
        payment.setAmount(flight.getFlightFare());
        payment.setTransactionID(getTransactionID());
        payment.setUniqueID(UUID.randomUUID().toString());
        payment.setTransactionDate(getCurrentDateAndTime());
        paymentRepository.save(payment);

        flightBookEntity.setPaymentEntity(payment);
        // ----------------------------------------------------------------------------------------

        flightBookEntity.setFlightBookingSecretCode(UUID.randomUUID().toString());
        // flightBookEntity.setFlightBookingStatus("confirmed");
        flightBookEntity.setFlightBookingDate(getCurrentDateAndTime());

        flightBookRepository.save(flightBookEntity);

        passenger.setFlightBookingId(flightBookEntity.getFlightBookingId());
        passengerRepository.save(passenger);
        flightBookEntity.setPassengerEntity(passenger);

        payment.setFlightBookingId(flightBookEntity.getFlightBookingId());
        paymentRepository.save(payment);
        flightBookEntity.setPaymentEntity(payment);

        FlightBookEntity flightBookEntity1 = findByFlightBookId(flightBookEntity.getFlightBookingId());

        if(flightBookEntity1 == flightBookEntity) {
            flightBookEntity.setFlightBookingStatus("confirmed");
        } else {
            flightBookEntity.setFlightBookingStatus("not confirmed");
        }
        flightBookRepository.save(flightBookEntity);

        return flightBookEntity;

    }

    // --------------------------------------------------------------------------------
    // need to do business logic in the service implementation

    @Override
    public FlightBookEntity findByFlightBookId(Integer flightBookId) {
        return flightBookRepository.findById(flightBookId).get();
    }

    @Override
    public List<FlightBookEntity> getAllFlightBook() {
        return flightBookRepository.findAll();
    }

}


//passenger.setPassengerFullName(passenger.getPassengerFullName());
//passenger.setPassengerEmail(passenger.getPassengerEmail());
//passenger.setPassengerMobile(passenger.getPassengerMobile());
//passenger.setPassengerGender(passenger.getPassengerGender());
//passenger.setPassengerDateOfBirth(passenger.getPassengerDateOfBirth());
//passenger.setPassengerAddress(passenger.getPassengerAddress());

//payment.setPaymentType(payment.getPaymentType());
//payment.setPaymentTypeMethod(payment.getPaymentTypeMethod());


// user = userRepository.findById(user.getId()).get();
// flight = flightRepository.findById(flight.getFlightId()).get();


