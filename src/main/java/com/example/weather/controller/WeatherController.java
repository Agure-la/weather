package com.example.weather.controller;

import com.example.weather.dto.request.CurrentWeatherRequest;
import com.example.weather.dto.request.ForeCastRequest;
import com.example.weather.dto.request.WeatherRequest;
import com.example.weather.dto.response.Current;
import com.example.weather.dto.response.Hourly;
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

    @PostMapping
    public ResponseEntity<WeatherResponse> getWeather(@Valid @RequestBody WeatherRequest request) {
        WeatherResponse response = weatherService.getWeather(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/forecast")
    public ResponseEntity<WeatherResponse> getForecast(@Valid @RequestBody ForeCastRequest request) {
        return ResponseEntity.ok(weatherService.getForecast(request));
    }

    @PostMapping("/current")
    public ResponseEntity<WeatherResponse> getCurrent(@Valid @RequestBody CurrentWeatherRequest request) {
        return ResponseEntity.ok(weatherService.getCurrentWeather(request));
    }

    @PostMapping("/hourly")
    public ResponseEntity<WeatherResponse> hourly(@Valid @RequestBody WeatherRequest request) {
        return ResponseEntity.ok(weatherService.getHourlyWeather(request));
    }

    @PostMapping("/daily")
    public ResponseEntity<WeatherResponse> daily(@Valid @RequestBody WeatherRequest request) {
        return ResponseEntity.ok(weatherService.getDailyWeather(request));
    }
}
