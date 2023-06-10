package com.gridnine.testing.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Bean that represents a flight.
 */
public class Flight {
    private final List<Segment> segments;

    Flight(final List<Segment> segs) {
        segments = segs;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public boolean arrivalBeforeDeparture(){
        return getSegments().stream()
                .anyMatch(segment -> segment.getDepartureDate().isBefore(segment.getArrivalDate()));
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }


}
