package com.example.weather.controller;

import com.example.weather.dto.request.CreateLocationRequest;
import com.example.weather.entity.Location;
import com.example.weather.service.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/locations")
public class LocationController {
    private final LocationService locationService;

    @PostMapping
    public ResponseEntity<Location> create(
            @Valid @RequestBody CreateLocationRequest request) {

        return ResponseEntity.ok(
                locationService.create(request));
    }
}
