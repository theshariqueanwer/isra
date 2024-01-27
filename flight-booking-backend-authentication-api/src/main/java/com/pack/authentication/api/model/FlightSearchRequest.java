package com.pack.authentication.api.model;


import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FlightSearchRequest {

    private String flightFrom;
    private String flightTo;
    private String flightDate;

}
