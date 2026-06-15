package com.example.weather.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CurrentWeatherRequest {
    @NotBlank
    private String city;
    private Boolean ai;
    private String units;
    private String lang;
}
