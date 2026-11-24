package com.example.user_side_service.repository;

import com.example.user_side_service.model.Itinerary;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ItineraryRepository extends MongoRepository<Itinerary, String> {
    Optional<Itinerary> findByTripId(String tripId);
}
