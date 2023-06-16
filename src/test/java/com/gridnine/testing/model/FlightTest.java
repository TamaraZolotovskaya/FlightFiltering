package com.gridnine.testing.model;

import com.gridnine.testing.testFlights;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class FlightTest {

    @Test
    @DisplayName("When departure in the past then true")
    void departureInThePast(){
        Assertions.assertTrue(testFlights.flightWithDepartureInThePast.DepartureInThePast());
    }

    @Test
    @DisplayName("When departure in the future then false")
    void departureInTheFuture(){
        Assertions.assertFalse(testFlights.flightWithThreeHourGroundTime.DepartureInThePast());
    }

    @Test
    @DisplayName("When arrival after departure then false")
    void arrivalAfterDeparture() {
        Assertions.assertFalse(testFlights.flightWithThreeHourGroundTime.ArrivalBeforeDeparture());
    }

    @Test
    @DisplayName("When departure and arrival in the same time then false")
    void arrivalEqualDeparture() {
        Assertions.assertFalse(testFlights.flightWithArrivalEqualDeparture.ArrivalBeforeDeparture());
    }

    @Test
    @DisplayName("When arrival before departure then true")
    void arrivalBeforeDeparture() {
        Assertions.assertTrue(testFlights.flightWithArrivalBeforeDepartureSegment.ArrivalBeforeDeparture());
    }


    @Test
    @DisplayName("When one segment then ground time is zero")
    void zeroGroundTime() {
        Assertions.assertEquals(0, testFlights.flightWithOneNormalSegment.groundTime());
    }

    @Test
    @DisplayName("Ground time is three hour")
    void ThreeHoursGroundTime() {
        Assertions.assertEquals(3, testFlights.flightWithThreeHourGroundTime.groundTime());
    }
}