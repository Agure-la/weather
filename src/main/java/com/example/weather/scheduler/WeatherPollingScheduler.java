package com.example.weather.scheduler;

import com.example.weather.dto.response.WeatherResponse;
import com.example.weather.entity.Location;
import com.example.weather.repository.LocationRepository;
import com.example.weather.service.AlertService;
import com.example.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class WeatherPollingScheduler {
    private final LocationRepository locationRepository;
    private final AlertService alertService;
    private final WeatherService weatherService;

    @Scheduled(fixedDelay = 900000)
    public void pollWeather() {

        int page = 0;
        int size = 100;

        Page<Location> locationsPage;

        do {
            locationsPage = locationRepository.findAll(PageRequest.of(page, size));

            locationsPage.getContent().forEach(location -> {
              //  WeatherResponse weather = weatherService.getWeather(location.getLatitude(), location.getLongitude(), 7, true, "metric", "en");
            //    alertService.evaluate(location, weather);
            });

            page++;

        } while (locationsPage.hasNext());
    }
}
