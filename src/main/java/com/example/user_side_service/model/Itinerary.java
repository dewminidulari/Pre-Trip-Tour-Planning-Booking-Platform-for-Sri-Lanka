package com.example.user_side_service.model;

import com.example.user_side_service.dto.DayPlan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "itineraries")
public class Itinerary {

    @Id
    private String id;

    private String tripId;

    private String userId;

    private int totalDays;

    private List<DayPlan> days;

    private boolean mapSuggested;

    private Instant createdAt;
}
