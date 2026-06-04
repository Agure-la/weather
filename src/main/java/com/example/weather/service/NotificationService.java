package com.example.weather.service;

import com.example.weather.entity.WeatherAlert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {
    public void sendAlert(
            WeatherAlert alert) {

        log.warn(
                "Weather alert triggered: {}",
                alert.getMessage());

        // email
        // SMS
        // Kafka event
    }
}
