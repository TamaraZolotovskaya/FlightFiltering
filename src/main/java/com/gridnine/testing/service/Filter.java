package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    public static List<Flight> filterDepartingInThePast(List<Flight> flights) {
        return flights.parallelStream()
                .filter(flight -> flight.getSegments().get(0).getDepartureDate().isAfter(LocalDateTime.now()))
                .collect(Collectors.toList());
    }

    public static List<Flight> filterArrivalBeforeDeparture(List<Flight> flights) {
        return flights.parallelStream()
                .filter(Flight::arrivalBeforeDeparture)
                .collect(Collectors.toList());
    }




}
