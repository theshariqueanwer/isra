package com.pack.authentication.api.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "flights")
public class FlightEntity {

    @Transient
    public static final String FLIGHT_SEQUENCE_NAME = "flight_sequence";

    @Id
    @MongoId
    private Integer flightId;
    private String flightName;
    private String flightNumber;
    private String flightFrom;
    private String flightTo;
    private Double flightFare;
    private String flightDate;
    private String flightTime;
    private String flightSecretCode;
    private String flightServiceProvider;


//    private Integer flightId;
//    private Integer flightNumber;
//    private String flightCode;
//    private String flightSecretCode;
//    private String flightName;
//    private String flightFrom;
//    private String flightTo;
//    private String flightEachSeatCost;
//    private Integer flightNumberOfSeatEachDay;
//    private String flightServiceProvider;
//    private Date flightAvailableDateFrom;
//    private Date flightAvailableDateTo;
//    private Date flightDepartureTime;
//    private Date flightArrivalTime;


}
