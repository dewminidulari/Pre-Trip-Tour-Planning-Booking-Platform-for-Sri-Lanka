package com.example.user_side_service.service;

import com.example.user_side_service.dto.TripRequest;
import com.example.user_side_service.model.Trip;
import com.example.user_side_service.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;

    public Trip createTrip(TripRequest request) {
        if (request.getDepartureDate().isBefore(request.getArrivalDate())) {
            throw new IllegalArgumentException("Departure date cannot be before arrival date");
        }

        Trip trip = Trip.builder()
                .userId(request.getUserId())
                .destinations(request.getDestinations())
                .arrivalDate(request.getArrivalDate())
                .departureDate(request.getDepartureDate())
                .travellersCount(request.getTravellersCount())
                .totalBudget(request.getTotalBudget())
                .preferredTransport(
                        (request.getPreferredTransport() == null || request.getPreferredTransport().isBlank())
                                ? "Private Car"
                                : request.getPreferredTransport().trim()
                )
                .createdAt(Instant.now())
                .build();

        return tripRepository.save(trip);
    }

    public Trip getTripById(String tripId) {
        return tripRepository.findById(tripId)
                .orElseThrow(() -> new IllegalArgumentException("Trip not found with id: " + tripId));
    }

    public List<Trip> getTripsByUserId(String userId) {
        return tripRepository.findByUserId(userId);
    }
}