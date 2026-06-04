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

    @GetMapping
    public ResponseEntity<WeatherResponse> getWeather(@RequestBody WeatherRequest request) {
        WeatherResponse response = weatherService.getWeather(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/forecast")
    public ResponseEntity<WeatherResponse> getForecast(@Valid @RequestBody ForeCastRequest request) {
        return ResponseEntity.ok(weatherService.getForecast(request));
    }

    @GetMapping("/current")
    public ResponseEntity<Current> getCurrent(@RequestBody CurrentWeatherRequest request) {
        return ResponseEntity.ok(weatherService.getCurrentWeather(request));
    }

    @GetMapping("/hourly")
    public ResponseEntity<Hourly> hourly(@RequestBody WeatherRequest request) {
        return ResponseEntity.ok(weatherService.getHourlyWeather(request));
    }

    @GetMapping("/daily")
    public ResponseEntity<WeatherResponse> daily(@RequestBody WeatherRequest request) {
        return ResponseEntity.ok(weatherService.getDailyWeather(request));
    }
}
