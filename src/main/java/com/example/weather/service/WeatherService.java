package com.example.weather.service;

import com.example.weather.client.WeatherAiClient;
import com.example.weather.dto.request.WeatherRequest;
import com.example.weather.dto.response.WeatherResponse;
import com.example.weather.entity.Location;
import com.example.weather.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherAiClient weatherAiClient;
    private final LocationRepository locationRepository;

    //@Cacheable(value = "weather", key = "#lat + ':' + #lon + ':' + #days + ':' + #ai + ':' + #units + ':' + #lang")
    public WeatherResponse getWeather(WeatherRequest request) {
        Integer days = request.getDays() != null ? request.getDays() : 7;
        Boolean ai = request.getAi() != null ? request.getAi() : true;
        String units = request.getUnits() != null ? request.getUnits() : "metric";
        String lang = request.getLang() != null ? request.getLang() : "en";

        WeatherRequest normalized = new WeatherRequest();
        normalized.setLat(request.getLat());
        normalized.setLon(request.getLon());
        normalized.setDays(days);
        normalized.setAi(ai);
        normalized.setUnits(units);
        normalized.setLang(lang);

        return weatherAiClient.getWeather(normalized);
    }
}
