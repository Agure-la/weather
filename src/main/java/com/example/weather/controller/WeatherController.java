package com.example.weather.controller;

import com.example.weather.dto.request.ForeCastRequest;
import com.example.weather.dto.request.WeatherRequest;
import com.example.weather.dto.response.WeatherResponse;
import com.example.weather.service.WeatherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping
    public ResponseEntity<WeatherResponse> getWeather(WeatherRequest request) {
        WeatherResponse response = weatherService.getWeather(request);
        System.out.println("response " + response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/forecast")
    public ResponseEntity<WeatherResponse> getForecast(@Valid @RequestBody ForeCastRequest request) {
        return ResponseEntity.ok(weatherService.getForecast(request));
    }
}
