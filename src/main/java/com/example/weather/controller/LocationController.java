package com.example.weather.controller;

import com.example.weather.dto.request.CreateLocationRequest;
import com.example.weather.dto.response.LocationResponse;
import com.example.weather.entity.Location;
import com.example.weather.service.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/locations")
public class LocationController {
    private final LocationService locationService;

    @PostMapping
    public ResponseEntity<LocationResponse> create(@Valid @RequestBody CreateLocationRequest request) {
        return ResponseEntity.ok(locationService.create(request));
    }

    @GetMapping("/{city}")
    public ResponseEntity<LocationResponse> getByCity(@PathVariable String city) {
        return ResponseEntity.ok(locationService.getByCity(city));
    }

    @GetMapping
    public ResponseEntity<Page<LocationResponse>> getAll(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(locationService.getAllLocations(page, size));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<LocationResponse>> search(@RequestParam String city, @RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(locationService.searchByCity(city, page, size));
    }
}
