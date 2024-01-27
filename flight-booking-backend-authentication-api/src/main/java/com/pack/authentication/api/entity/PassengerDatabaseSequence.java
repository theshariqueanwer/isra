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
@Document(collection = "passenger_id_sequence")
public class PassengerDatabaseSequence {

    @Id
    private String id;
    private Integer passengerSequenceNumber;

}
