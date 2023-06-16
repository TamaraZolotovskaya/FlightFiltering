package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.testFlights;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterTest {

    List<Flight> expectedFlights = Arrays.asList(testFlights.flightWithTwoHourGroundTime,
            testFlights.flightWithArrivalEqualDeparture,
            testFlights.flightWithOneNormalSegment);

    @Test
    @DisplayName("when the filterDepartingInThePast works correctly, then the filtered flights are equal expected flights")
    void filterDepartingInThePast() {
        List<Flight> flights = Arrays.asList(testFlights.flightWithDepartureInThePast,
                testFlights.flightWithTwoHourGroundTime,
                testFlights.flightWithArrivalEqualDeparture,
                testFlights.flightWithOneNormalSegment);
        assertEquals(Filter.filterDepartingInThePast(flights), expectedFlights);
    }

    @Test
    @DisplayName("when the filterArrivalBeforeDeparture works correctly, then the filtered flights are equal expected flights")
    void filterArrivalBeforeDeparture() {
        List<Flight> flights = Arrays.asList(testFlights.flightWithArrivalBeforeDepartureSegment,
                testFlights.flightWithTwoHourGroundTime,
                testFlights.flightWithArrivalEqualDeparture,
                testFlights.flightWithOneNormalSegment);
        assertEquals(Filter.filterArrivalBeforeDeparture(flights), expectedFlights);
    }

    @Test
    @DisplayName("when the filterMoreThanTwoHoursGroundTime works correctly, then the filtered flights are equal expected flights")
    void filterMoreThanTwoHoursGroundTime() {
        List<Flight> flights = Arrays.asList(testFlights.flightWithThreeHourGroundTime,
                testFlights.flightWithTwoHourGroundTime,
                testFlights.flightWithArrivalEqualDeparture,
                testFlights.flightWithOneNormalSegment);
        assertEquals(Filter.filterMoreThanTwoHoursGroundTime(flights), expectedFlights);
    }
}