package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.gridnine.testing.TestFlights.*;
import static org.junit.jupiter.api.Assertions.*;

class FilterTest {

    List<Flight> expectedFlights = Arrays.asList(flightWithTwoHourGroundTime,
            flightWithArrivalEqualDeparture,
            flightWithOneNormalSegment);

    @Test
    @DisplayName("when the filterDepartingInThePast works correctly, then the filtered flights are equal expected flights")
    void filterDepartingInThePast() {
        List<Flight> flights = Arrays.asList(flightWithDepartureInThePast,
                flightWithTwoHourGroundTime,
                flightWithArrivalEqualDeparture,
                flightWithOneNormalSegment);
        assertEquals(expectedFlights, Filter.filterDepartingInThePast(flights));
    }

    @Test
    @DisplayName("when the filterArrivalBeforeDeparture works correctly, then the filtered flights are equal expected flights")
    void filterArrivalBeforeDeparture() {
        List<Flight> flights = Arrays.asList(flightWithArrivalBeforeDepartureSegment,
                flightWithTwoHourGroundTime,
                flightWithArrivalEqualDeparture,
                flightWithOneNormalSegment);
        assertEquals(expectedFlights, Filter.filterArrivalBeforeDeparture(flights));
    }

    @Test
    @DisplayName("when the filterMoreThanTwoHoursGroundTime works correctly, then the filtered flights are equal expected flights")
    void filterMoreThanTwoHoursGroundTime() {
        List<Flight> flights = Arrays.asList(flightWithThreeHourGroundTime,
                flightWithTwoHourGroundTime,
                flightWithArrivalEqualDeparture,
                flightWithOneNormalSegment);
        assertEquals(expectedFlights, Filter.filterMoreThanTwoHoursGroundTime(flights));
    }
}