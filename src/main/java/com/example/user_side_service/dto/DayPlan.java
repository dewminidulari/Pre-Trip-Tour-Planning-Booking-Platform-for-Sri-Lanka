package com.example.user_side_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DayPlan {
    private int dayNumber;
    private String location;
    private List<String> activities;
    private String transportMode;
    private String mapNote;
}
