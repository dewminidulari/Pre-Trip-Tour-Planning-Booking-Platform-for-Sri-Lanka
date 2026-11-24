package com.example.user_side_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TripRequest {

    private String userId;

    @NotEmpty(message = "At least one destination is required")
    private List<String> destinations;

    @NotNull(message = "Arrival date is required")
    private LocalDate arrivalDate;

    @NotNull(message = "Departure date is required")
    private LocalDate departureDate;

    @Min(value = 1, message = "Travellers count must be at least 1")
    private int travellersCount;

    @Min(value = 0, message = "Total budget cannot be negative")
    private double totalBudget;

    private String preferredTransport;
}
