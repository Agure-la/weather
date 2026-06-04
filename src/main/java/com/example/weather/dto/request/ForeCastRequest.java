package com.example.weather.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ForeCastRequest {
    @NotBlank
    private String city;

    private Integer days;
    private Boolean ai;
}
