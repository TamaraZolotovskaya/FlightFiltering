package com.gridnine.testing.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Bean that represents a flight.<br>
 *Flight is the transportation of a passenger from one point to another with possible intermediate landings.
 * It can be represented as a list of one or more elementary movements, each of which is {@link Segment}.
 */
public class Flight {
    private final List<Segment> segments;

    public Flight(final List<Segment> segs) {
        segments = segs;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    /**
     * Returns {@code true} if the departure the {@link Flight} has already,
     * {@code false} otherwise.
     *
     * @return {@code true} if the departure has already,<br>
     * {@code false} if there hasn't been a departure yet.
     */
    public boolean DepartureInThePast() {
        return getSegments().stream()
                .anyMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now()));
    }

    /**
     * Returns {@code true} if the {@link Flight} has a {@link Segment} with an arrival date earlier than the departure date,
     * {@code false} otherwise.
     *
     * @return {@code true} if true there is a {@link Segment} with an arrival date earlier than the departure date,<br>
     * {@code false} if each {@link Segment} has a departure before arrival.
     */
    public boolean ArrivalBeforeDeparture() {
        return getSegments().stream()
                .anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()));
    }

    /**
     *Counts the total time on the ground between segments (in hours).
     *Time on the ground is the interval between the arrival of one {@link Segment} and the departure of the next one.
     *
     * @return total time on the ground in hours.
     */
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
