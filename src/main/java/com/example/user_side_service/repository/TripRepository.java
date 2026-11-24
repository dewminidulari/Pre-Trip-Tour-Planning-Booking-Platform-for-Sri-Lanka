package com.example.user_side_service.repository;

import com.example.user_side_service.model.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TripRepository extends MongoRepository<Trip, String> {
    List<Trip> findByUserId(String userId);
}