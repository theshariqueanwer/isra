package com.pack.authentication.api.entity;


import com.pack.authentication.api.model.UserEntityRequest;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "flight_books")
public class FlightBookEntity {

    @Transient
    public static final String FLIGHT_BOOK_SEQUENCE_NAME = "flight_book_sequence";

    @Id
    @MongoId
    private Integer flightBookingId;
    private String flightBookingNumber;
    // private UserEntity userEntity;
    private UserEntityRequest userEntityRequest;
    private FlightEntity flightEntity;
    private PassengerEntity passengerEntity;
    private PaymentEntity paymentEntity;
    private String flightBookingSecretCode;
    private String flightBookingStatus;
    private String flightBookingDate;

}


//    private Integer flightBookId;
//    private UserEntity userEntity;
//    private Integer userId;
//    private String fullName;
//    private String email;
//    private String mobile;
//    private FlightEntity flightEntity;
//    private Integer flightId;
//    private String flightName;
//    private String flightNumber;
//    private String flightFrom;
//    private String flightTo;
//    private Double flightCost;
//    private String flightDate;
//    private String flightTime;
//    private String flightServiceProvider;
//    private String flightBookingDate;

