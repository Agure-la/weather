package com.example.weather.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "locations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String city;

    private Double latitude;

    private Double longitude;

    private LocalDateTime createdAt;
}
