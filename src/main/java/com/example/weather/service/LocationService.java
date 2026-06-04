package com.example.weather.service;

import com.example.weather.dto.request.CreateLocationRequest;
import com.example.weather.entity.Location;
import com.example.weather.repository.LocationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class LocationService {
    private final LocationRepository repository;

    public Location create(
            CreateLocationRequest request) {

        Location location = Location.builder()
                .city(request.city())
                .latitude(request.lat())
                .longitude(request.lon())
                .createdAt(LocalDateTime.now())
                .build();

        return repository.save(location);
    }
}
