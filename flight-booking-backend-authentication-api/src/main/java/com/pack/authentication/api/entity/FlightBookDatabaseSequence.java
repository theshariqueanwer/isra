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
@Document(collection = "flight_book_id_sequence")
public class FlightBookDatabaseSequence {

    @Id
    private String id;
    private Integer flightBookSequenceNumber;

}
