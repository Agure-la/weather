package com.example.weather.repository;

import com.example.weather.entity.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {
    Optional<Location> findByCityIgnoreCase(String city);
    Page<Location> findAll(Pageable pageable);
    Page<Location> findByCityContainingIgnoreCase(String city, Pageable pageable);
}
