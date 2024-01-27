package com.pack.authentication.api.entity;


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
@Document(collection = "passengers")
public class PassengerEntity {

//    PassengerDatabaseSequence

//    PassengerSequenceNumberGeneratorService

    @Transient
    public static final String PASSENGER_SEQUENCE_NAME = "passenger_sequence";

    @Id
    @MongoId
    private Integer passengerId;
    private String passengerFullName;
    private String passengerEmail;
    private String passengerMobile;
    private String passengerGender;
    private String passengerDateOfBirth;
    private String passengerAddress;
    private String passengerSecretCode;
    private Integer flightBookingId;

}
