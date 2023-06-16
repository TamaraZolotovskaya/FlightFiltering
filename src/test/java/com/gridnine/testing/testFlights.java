package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.List;

public class testFlights {
    public static LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
    public static Segment normalSegment = new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2));
    public static Segment normalSegment2 = new Segment(threeDaysFromNow.plusHours(4), threeDaysFromNow.plusHours(6));
    public static Segment normalSegment3 = new Segment(threeDaysFromNow.plusHours(7), threeDaysFromNow.plusHours(8));
    public static Segment departureInThePastSegment = new Segment(threeDaysFromNow.minusDays(4), threeDaysFromNow.minusDays(4).plusHours(2));
    public static Segment arrivalBeforeDepartureSegment = new Segment(threeDaysFromNow, threeDaysFromNow.minusHours(6));
    public static Segment arrivalEqualDepartureSegment = new Segment(threeDaysFromNow, threeDaysFromNow);
    public static Flight flightWithOneNormalSegment = new Flight(List.of(normalSegment));
    public static Flight flightWithThreeHourGroundTime = new Flight(List.of(normalSegment, normalSegment2, normalSegment3));
    public static Flight flightWithTwoHourGroundTime = new Flight(List.of(normalSegment, normalSegment2));
    public static Flight flightWithDepartureInThePast = new Flight(List.of(departureInThePastSegment, normalSegment));
    public static Flight flightWithArrivalEqualDeparture = new Flight(List.of(arrivalEqualDepartureSegment));
    public static Flight flightWithArrivalBeforeDepartureSegment = new Flight(List.of(arrivalBeforeDepartureSegment));

}
