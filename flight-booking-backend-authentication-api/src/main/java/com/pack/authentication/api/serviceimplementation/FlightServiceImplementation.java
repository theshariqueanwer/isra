package com.pack.authentication.api.serviceimplementation;

import com.pack.authentication.api.entity.FlightEntity;
import com.pack.authentication.api.entity.UserEntity;
import com.pack.authentication.api.model.*;
import com.pack.authentication.api.repository.FlightRepository;
import com.pack.authentication.api.service.FlightSequenceNumberGeneratorService;
import com.pack.authentication.api.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class FlightServiceImplementation implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightSequenceNumberGeneratorService flightSequenceNumberGeneratorService;

//    private Integer flightId;
//    private String flightName;
//    private String flightNumber;
//    private String flightFrom;
//    private String flightTo;
//    private Double flightCost;
//    private String flightDate;
//    private String flightTime;
//    private String flightSecretCode;
//    private String flightServiceProvider;

    public String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String getDate = formatter.format(date);
        return getDate;
    }

    public String getCurrentTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        String getTime = formatter.format(date);
        return getTime;
    }

    public String getDateAddedFewMonthsToCurrentDate() {

        LocalDate date = LocalDate.now();
        LocalDate newDate = date.plusMonths(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String newDate1 = formatter.format(newDate);
        return newDate1;
    }

    public String getTimeAddedFewHoursToCurrentTime() {

        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        String newTime1 = formatter.format(newTime);
        return newTime1;
    }


    @Override
    public FlightEntity saveFlight(FlightEntity flightEntity) {

        // flightId will be auto generated
        // sequence generator
        flightEntity.setFlightId(flightSequenceNumberGeneratorService.getFlightIdSequenceNumber(FlightEntity.FLIGHT_SEQUENCE_NAME));

        // flightName will be manually

        // flightFrom will come manually

        // flightTo will come manually

        // flightCost will come manually

        flightEntity.setFlightDate(getDateAddedFewMonthsToCurrentDate());

        flightEntity.setFlightTime(getTimeAddedFewHoursToCurrentTime());

        flightEntity.setFlightSecretCode(UUID.randomUUID().toString());

        flightEntity.setFlightServiceProvider(flightEntity.getFlightName());

        flightRepository.save(flightEntity);

        // ========================================================================================

        FlightEntity flight = flightRepository.findById(flightEntity.getFlightId()).get();
        System.out.println(flight);

        Integer number = (int) (Math.random()*999);
        System.out.println(number);
        number = 100 + number;
        System.out.println(number);

//        String code = flight.getFlightNumber();
//        flight.setFlightNumber(code + "-" + number);
//        System.out.println(code);

        flight.setFlightNumber(flight.getFlightNumber() + "-" + number);

        return flightRepository.save(flight);

    }

    // ----------------------------------------------------------------------------------
    // need to do business logic in the service implementation

    @Override
    public FlightEntity getFlightByFlightId(Integer flightId) {
        return flightRepository.findById(flightId).get();
    }

    @Override
    public List<FlightEntity> getAllFlight() {
        return flightRepository.findAll();
    }

    // ================================================================================================

    @Override
    public List<FlightEntity> findByFlightFromAndFlightToAndFlightDate(FlightSearchRequest flightSearchRequest) {
        List<FlightEntity> flightEntityList = flightRepository.
                findByFlightFromAndFlightToAndFlightDate(
                        flightSearchRequest.getFlightFrom(),
                        flightSearchRequest.getFlightTo(),
                        flightSearchRequest.getFlightDate()
                );
        return flightEntityList;
    }

    // ----------------------------------------------------------------------------------
    // need to do business logic in the service implementation

}





















    // ---------------------------------- some code ----------------------------------------

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


//    @Override
//    public FlightEntity saveFlight(FlightEntity flightEntity) {
//        // flightId will be auto generated
//
//        Integer flightNumber = (int) (Math.random()*999);
//
//        flightEntity.setFlightNumber(flightNumber);
//
//        String code = flightEntity.getFlightCode();
//        if (code == "SG") {
//            flightEntity.setFlightCode(code + flightNumber);
//        } else if (code == "IG") {
//            flightEntity.setFlightCode(code + flightNumber);
//        } else if (code == "AA") {
//            flightEntity.setFlightCode(code + flightNumber);
//        } else if (code == "GO") {
//            flightEntity.setFlightCode(code + flightNumber);
//        } else if (code == "") {
//            flightEntity.setFlightCode(code + flightNumber);
//        }
//
//        flightEntity.setFlightSecretCode(UUID.randomUUID().toString());
//
//        // flightName will come manually
//
//        // flightFrom will come manually
//
//        // flightTo will come manually
//
//        // flightEachSeatCost will come manually
//
//        flightEntity.setFlightNumberOfSeatEachDay(180);
//
//        flightEntity.setFlightServiceProvider(flightEntity.getFlightName());
//
//        flightEntity.setFlightAvailableDateFrom(new Date(String.valueOf(currentDate())));
//
//        flightEntity.setFlightAvailableDateTo(new Date());
//
//        flightEntity.setFlightDepartureTime(new Date());
//
//        flightEntity.setFlightArrivalTime(new Date());
//
//        //
//
//        return flightRepository.save(flightEntity);
//    }

//    public String getCurrentDate() {
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        Date date = new Date();
//        return date;
//    }

//        11-04-2022
//        11:11:58
//        null

//        if (code == "SJ") {
//        flight.setFlightNumber(code + "-" + number);
//        } else if (code == "IG") {
//        flight.setFlightNumber(code + "-" + number);
//        } else if (code == "AA") {
//        flight.setFlightNumber(code + "-" + number);
//        } else if (code == "GA") {
//        flight.setFlightNumber(code + "-" + number);
//        } else if (code == "AI") {
//        flight.setFlightNumber(code + "-" + number);
//        }





