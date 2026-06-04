package com.example.weather.repository;

import com.example.weather.entity.WeatherAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherAlertRepository extends JpaRepository<WeatherAlert, String> {
}
