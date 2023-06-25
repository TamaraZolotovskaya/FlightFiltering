package com.gridnine.testing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.gridnine.testing.TestFlights.*;
import static org.junit.jupiter.api.Assertions.*;


class FlightTest {

    @Test
    @DisplayName("When departure in the past then true")
    void departureInThePast() {
        assertTrue(flightWithDepartureInThePast.DepartureInThePast());
    }

    @Test
    @DisplayName("When departure in the future then false")
    void departureInTheFuture() {
        assertFalse(flightWithThreeHourGroundTime.DepartureInThePast());
    }

    @Test
    @DisplayName("When arrival after departure then false")
    void arrivalAfterDeparture() {
        assertFalse(flightWithThreeHourGroundTime.ArrivalBeforeDeparture());
    }

    @Test
    @DisplayName("When departure and arrival in the same time then false")
    void arrivalEqualDeparture() {
        assertFalse(flightWithArrivalEqualDeparture.ArrivalBeforeDeparture());
    }

    @Test
    @DisplayName("When arrival before departure then true")
    void arrivalBeforeDeparture() {
        assertTrue(flightWithArrivalBeforeDepartureSegment.ArrivalBeforeDeparture());
    }


    @Test
    @DisplayName("When one segment then ground time is zero")
    void zeroGroundTime() {
        assertEquals(0, flightWithOneNormalSegment.groundTime());
    }

    @Test
    @DisplayName("Ground time is three hour")
    void ThreeHoursGroundTime() {
        assertEquals(3, flightWithThreeHourGroundTime.groundTime());
    }
}