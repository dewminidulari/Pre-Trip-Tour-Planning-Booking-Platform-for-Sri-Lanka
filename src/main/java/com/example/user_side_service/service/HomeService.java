package com.example.user_side_service.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HomeService {

    public Map<String, Object> getHomeData() {
        return Map.of(
                "title", "Explore Sri Lanka",
                "quickActions", List.of(
                        "Explore Sri Lanka",
                        "Plan My Trip",
                        "Hotels and Activities",
                        "Transport",
                        "My Bookings",
                        "Login"
                ),
                "featuredDestinations", List.of("Kandy", "Ella", "Galle", "Sigiriya", "Nuwara Eliya")
        );
    }
}
