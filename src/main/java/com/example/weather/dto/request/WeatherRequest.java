package com.example.weather.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherRequest {
    private Double lat;
    private Double lon;

    private Integer days;
    private Boolean ai;
    private String units;
    private String lang;
}
