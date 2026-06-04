package com.example.weather.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "weather_alerts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String locationId;

    private String alertType;

    private String message;

    private LocalDateTime createdAt;
}
