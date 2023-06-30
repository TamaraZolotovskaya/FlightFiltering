package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.util.List;
import java.util.stream.Collectors;

/**
 *Contains methods for filtering flights.
 *
 * @see Flight
 */
public class Filter {

    /**
     *Excludes from the list of flights those where the departure occurred before the current time.
     *
     * @param flights list of flights to filter.
     * @return a list of flights, where all flights depart after the current time.
     * @see Flight
     */
    public static List<Flight> filterDepartingInThePast(List<Flight> flights) {
        return flights.parallelStream()
                .filter(flight -> !flight.DepartureInThePast())
                .collect(Collectors.toList());
    }

    /**
     *Excludes from the list of flights those that have segments with an arrival date before the departure date.
     *
     * @param flights list of flights to filter.
     * @return a list of flights where all flights contain only segments with an arrival date after the departure date.
     * @see Flight
     */
    public static List<Flight> filterArrivalBeforeDeparture(List<Flight> flights) {
        return flights.parallelStream()
                .filter(flight -> !flight.ArrivalBeforeDeparture())
                .collect(Collectors.toList());
    }

    /**
     *Excludes from the list of flights those whose total time on the ground is more than two hours.
     *Time on the ground is the interval between the arrival of one {@link Segment} and the departure of the next one.
     *
     * @param flights list of flights to filter.
     * @return a list of flights where the total time spent by each flight on the ground does not exceed two hours.
     * @see Flight
     */
    public static List<Flight> filterMoreThanTwoHoursGroundTime(List<Flight> flights) {
        return flights.parallelStream()
                .filter(flight -> flight.groundTime()<=2)
                .collect(Collectors.toList());
    }

}