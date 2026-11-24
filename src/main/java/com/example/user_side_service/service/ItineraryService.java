package com.example.user_side_service.service;

import com.example.user_side_service.dto.DayPlan;
import com.example.user_side_service.model.Itinerary;
import com.example.user_side_service.model.Trip;
import com.example.user_side_service.repository.ItineraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItineraryService {

    private final TripService tripService;
    private final ItineraryRepository itineraryRepository;

    public Itinerary generateItinerary(String tripId) {
        Trip trip = tripService.getTripById(tripId);

        long rawDays = ChronoUnit.DAYS.between(trip.getArrivalDate(), trip.getDepartureDate()) + 1;
        int totalDays = (int) Math.max(1, rawDays);

        List<String> destinations = trip.getDestinations();
        List<DayPlan> dayPlans = new ArrayList<>();

        for (int day = 1; day <= totalDays; day++) {
            String destination = destinations.get((day - 1) % destinations.size());
            dayPlans.add(DayPlan.builder()
                    .dayNumber(day)
                    .location(destination)
                    .activities(List.of(
                            "Morning exploration in " + destination,
                            "Local cuisine & cultural stop in " + destination,
                            "Evening leisure & hotel check-in"
                    ))
                    .transportMode(trip.getPreferredTransport())
                    .mapNote("Suggested route pin for " + destination + " (Day " + day + ")")
                    .build());
        }

        Itinerary itinerary = itineraryRepository.findByTripId(tripId)
                .map(existing -> {
                    existing.setTotalDays(totalDays);
                    existing.setDays(dayPlans);
                    existing.setMapSuggested(true);
                    return existing;
                })
                .orElseGet(() -> Itinerary.builder()
                        .tripId(trip.getId())
                        .userId(trip.getUserId())
                        .totalDays(totalDays)
                        .days(dayPlans)
                        .mapSuggested(true)
                        .createdAt(Instant.now())
                        .build());

        return itineraryRepository.save(itinerary);
    }

    public Itinerary getItineraryByTripId(String tripId) {
        return itineraryRepository.findByTripId(tripId)
                .orElseThrow(() -> new IllegalArgumentException("Itinerary not found for tripId: " + tripId));
    }
}
