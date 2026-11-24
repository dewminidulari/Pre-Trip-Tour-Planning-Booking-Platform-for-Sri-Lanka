package com.example.user_side_service.controller;

import com.example.user_side_service.model.Itinerary;
import com.example.user_side_service.service.ItineraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/itineraries")
@RequiredArgsConstructor
public class ItineraryController {

    private final ItineraryService itineraryService;

    @PostMapping("/generate/{tripId}")
    public ResponseEntity<Itinerary> generateItinerary(@PathVariable String tripId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itineraryService.generateItinerary(tripId));
    }

    @GetMapping("/{tripId}")
    public ResponseEntity<Itinerary> getItinerary(@PathVariable String tripId) {
        return ResponseEntity.ok(itineraryService.getItineraryByTripId(tripId));
    }
}
