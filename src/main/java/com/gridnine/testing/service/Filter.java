package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    public static List<Flight> filterDepartingInThePast(List<Flight> flights) {
        return flights.parallelStream()
                .filter(flight -> !flight.DepartureInThePast())
                .collect(Collectors.toList());
    }

    public static List<Flight> filterArrivalBeforeDeparture(List<Flight> flights) {
        return flights.parallelStream()
                .filter(flight -> !flight.ArrivalBeforeDeparture())
                .collect(Collectors.toList());
    }

    public static List<Flight> filterMoreThanTwoHoursGroundTime(List<Flight> flights) {
        return flights.parallelStream()
                .filter(flight -> flight.groundTime()<=2)
                .collect(Collectors.toList());
    }

}
