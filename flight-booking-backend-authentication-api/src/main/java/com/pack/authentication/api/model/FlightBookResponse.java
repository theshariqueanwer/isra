package com.pack.authentication.api.model;


import com.pack.authentication.api.entity.FlightEntity;
import com.pack.authentication.api.entity.UserEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FlightBookResponse {

    private Integer flightBookId;
    private UserEntity userEntity;
    private FlightEntity flightEntity;
    private String flightBookingDate;
}
