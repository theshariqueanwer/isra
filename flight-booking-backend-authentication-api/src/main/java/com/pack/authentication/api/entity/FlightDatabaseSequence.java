package com.pack.authentication.api.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "flight_id_sequence")
public class FlightDatabaseSequence {

    @Id
    private String id;
    private Integer flightSequenceNumber;

}


// FlightDatabaseSequence