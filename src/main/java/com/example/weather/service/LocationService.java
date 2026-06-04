package com.example.weather.service;

import com.example.weather.dto.request.CreateLocationRequest;
import com.example.weather.dto.response.LocationResponse;
import com.example.weather.entity.Location;
import com.example.weather.repository.LocationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class LocationService {
    private final LocationRepository repository;

    public  LocationResponse toResponse(Location location) {
        return new LocationResponse(
                location.getId(),
                location.getCity(),
                location.getLatitude(),
                location.getLongitude(),
                location.getCreatedAt()
        );
    }

    public LocationResponse  create(CreateLocationRequest request) {

        Location location = Location.builder()
                .city(request.city())
                .latitude(request.lat())
                .longitude(request.lon())
                .createdAt(LocalDateTime.now())
                .build();

        return toResponse(repository.save(location));
    }

    public LocationResponse getByCity(String city) {
        Location location = repository.findByCityIgnoreCase(city).orElseThrow(() -> new RuntimeException("Location not found"));
        return toResponse(location);
    }

    public Page<LocationResponse> getAllLocations(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return repository.findAll(pageable)
                .map(this::toResponse);
    }

    public Page<LocationResponse> searchByCity(String city, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return repository.findByCityContainingIgnoreCase(city, pageable)
                .map(this::toResponse);
    }
}
