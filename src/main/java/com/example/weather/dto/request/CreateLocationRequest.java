package com.example.weather.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;

public record CreateLocationRequest(@NotBlank String city, @NotNull Double lat, @NotNull Double lon) {
}
