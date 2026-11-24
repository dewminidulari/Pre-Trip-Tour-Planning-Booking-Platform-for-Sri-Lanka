package com.example.user_side_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String fullName;

    @Indexed(unique = true)
    private String email;

    private String password;

    private String country;

    private String nicNumber;

    private String phoneNumber;

    // Flowchart roles: USER, SUPER_ADMIN, HOTEL_AGENT, TRAVEL_AGENT, ACTIVITY_AGENT
    private String role;

    private Instant createdAt;
}
