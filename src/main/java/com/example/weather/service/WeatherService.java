package com.example.weather.service;

import com.example.weather.client.WeatherAiClient;
import com.example.weather.dto.request.CurrentWeatherRequest;
import com.example.weather.dto.request.ForeCastRequest;
import com.example.weather.dto.request.WeatherRequest;
import com.example.weather.dto.response.Current;
import com.example.weather.dto.response.Hourly;
import com.example.weather.dto.response.WeatherResponse;
import com.example.weather.entity.Location;
import com.example.weather.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherAiClient weatherAiClient;
    private final LocationRepository locationRepository;

    //@Cacheable(value = "weather", key = "#lat + ':' + #lon + ':' + #days + ':' + #ai + ':' + #units + ':' + #lang")
    public WeatherResponse getWeather(WeatherRequest request) {
        Location location = locationRepository.findByCityIgnoreCase(request.getCity()).orElseThrow(() -> new RuntimeException("Location not found for city: " + request.getCity()));

        Integer days = request.getDays() != null ? request.getDays() : 7;
        Boolean ai = request.getAi() != null ? request.getAi() : true;
        String units = request.getUnits() != null ? request.getUnits() : "metric";
        String lang = request.getLang() != null ? request.getLang() : "en";

        WeatherRequest normalized = new WeatherRequest();
        normalized.setCity(request.getCity());
        normalized.setDays(days);
        normalized.setAi(ai);
        normalized.setUnits(units);
        normalized.setLang(lang);

        return weatherAiClient.getWeather(location.getLatitude().floatValue(), location.getLongitude().floatValue(), normalized);
    }

    public WeatherResponse getForecast(ForeCastRequest request) {

        Location location = locationRepository.findByCityIgnoreCase(request.getCity())
                .orElseThrow(() -> new RuntimeException("City not found: " + request.getCity()));
        int days = request.getDays() != null ? request.getDays() : 7;
        boolean ai = request.getAi() != null ? request.getAi() : true;
        return weatherAiClient.getForecast(location.getLatitude(), location.getLongitude(), days, ai);
    }

    public WeatherResponse getCurrentWeather(CurrentWeatherRequest request) {
        Location location = locationRepository.findByCityIgnoreCase(request.getCity())
                .orElseThrow(() -> new RuntimeException("City not found: " + request.getCity()));

        boolean ai = request.getAi() != null ? request.getAi() : true;
        String units = request.getUnits() != null ? request.getUnits() : "metric";
        String lang = request.getLang() != null ? request.getLang() : "en";
        return weatherAiClient.getCurrentWeather(location.getLatitude(), location.getLongitude(), ai, units, lang);
    }

    private Location getLocation(String city) {
        return locationRepository.findByCityIgnoreCase(city).orElseThrow(() -> new RuntimeException("City not found: " + city));
    }

    public WeatherResponse getHourlyWeather(WeatherRequest request) {

        Location location = getLocation(request.getCity());
        int days = request.getDays() != null ? request.getDays() : 7;
        boolean ai = request.getAi() != null ? request.getAi() : true;
        String units = request.getUnits() != null ? request.getUnits() : "metric";
        return weatherAiClient.getHourlyWeather(location.getLatitude(), location.getLongitude(), days, ai, units);
    }

    public WeatherResponse getDailyWeather(WeatherRequest request) {
        Location location = getLocation(request.getCity());
        int days = request.getDays() != null ? request.getDays() : 7;
        boolean ai = request.getAi() != null ? request.getAi() : true;
        String units = request.getUnits() != null ? request.getUnits() : "metric";
        return weatherAiClient.getDailyWeather(location.getLatitude(), location.getLongitude(), days, ai, units);
    }
}
