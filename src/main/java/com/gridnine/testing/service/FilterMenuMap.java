package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class FilterMenuMap {
    public static final Map<Integer, Consumer<List<Flight>>> filterMenuMap =
            Map.ofEntries(Map.entry(1, flights -> Filter.filterDepartingInThePast(flights).forEach(System.out::println)),
                    Map.entry(2, flights -> Filter.filterArrivalBeforeDeparture(flights).forEach(System.out::println)),
                    Map.entry(3, flights -> Filter.filterMoreThanTwoHoursGroundTime(flights).forEach(System.out::println))
            );
}
