package com.gridnine.testing.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Bean that represents a flight.
 */
public class Flight {
    private final List<Segment> segments;

    public Flight(final List<Segment> segs) {
        segments = segs;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public boolean DepartureInThePast() {
        return getSegments().stream()
                .anyMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now()));
    }

    public boolean ArrivalBeforeDeparture() {
        return getSegments().stream()
                .anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()));
    }

    public double groundTime() {
        List<Segment> segments = getSegments();
        double sum = 0;
        for (int i = 1; i < segments.size(); i++) {
            double diff = ChronoUnit.HOURS.between(segments.get(i - 1).getArrivalDate(), segments.get(i).getDepartureDate());
            sum = sum + diff;
        }
        return sum;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return Objects.equals(segments, flight.segments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(segments);
    }
}
