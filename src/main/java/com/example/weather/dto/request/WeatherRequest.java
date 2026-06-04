package com.example.weather.dto.request;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "cityName is required")
   private String cityName;
    private Integer days;
    private Boolean ai;
    private String units;
    private String lang;
}
