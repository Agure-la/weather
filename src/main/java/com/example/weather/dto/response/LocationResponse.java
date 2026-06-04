package com.example.weather.dto.response;

import java.time.LocalDateTime;

public record LocationResponse(
        String id,
        String city,
        Double latitude,
        Double longitude,
        LocalDateTime createdAt
) {
}
