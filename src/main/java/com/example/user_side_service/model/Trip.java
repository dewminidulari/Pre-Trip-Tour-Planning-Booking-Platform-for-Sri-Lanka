package com.example.user_side_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "trips")
public class Trip {

    @Id
    private String id;

    private String userId;

    private List<String> destinations;

    private LocalDate arrivalDate;

    private LocalDate departureDate;

    private int travellersCount;

    private double totalBudget;

    private String preferredTransport;

    private Instant createdAt;
}
