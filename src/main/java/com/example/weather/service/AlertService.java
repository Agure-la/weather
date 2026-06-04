package com.example.weather.service;

import com.example.weather.dto.response.WeatherResponse;
import com.example.weather.entity.Location;
import com.example.weather.entity.WeatherAlert;
import com.example.weather.repository.WeatherAlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AlertService {
    private final WeatherAlertRepository repository;
    private final NotificationService notificationService;

//    public void evaluate(Location location, WeatherResponse weather) {
//
//        if (weather.temperature() > 35) {
//
//            createAlert(
//                    location,
//                    "HIGH_TEMPERATURE",
//                    "Temperature exceeded 35°C");
//        }
//
//        if (weather.rainProbability() > 80) {
//
//            createAlert(
//                    location,
//                    "HEAVY_RAIN",
//                    "Rain probability above 80%");
//        }
//
//        if (weather.windSpeed() > 50) {
//
//            createAlert(
//                    location,
//                    "HIGH_WIND",
//                    "Wind speed exceeded threshold");
//        }
//    }

    private void createAlert(
            Location location,
            String type,
            String message) {

        WeatherAlert alert =
                WeatherAlert.builder()
                        .locationId(location.getId())
                        .alertType(type)
                        .message(message)
                        .createdAt(LocalDateTime.now())
                        .build();

        repository.save(alert);

        notificationService.sendAlert(alert);
    }
}
