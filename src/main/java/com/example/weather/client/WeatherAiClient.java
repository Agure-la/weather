package com.example.weather.client;

import com.example.weather.dto.request.WeatherRequest;
import com.example.weather.dto.response.Current;
import com.example.weather.dto.response.Hourly;
import com.example.weather.dto.response.WeatherResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import tools.jackson.databind.ObjectMapper;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherAiClient {

    private final WebClient weatherWebClient;

//    @Retry(name = "weather-ai")
//    @CircuitBreaker(name = "weather-ai")
public WeatherResponse getWeather(Float lat, Float lon,WeatherRequest request) {

    String response = weatherWebClient
            .get()
            .uri(uriBuilder -> uriBuilder
                    .path("/v1/weather")
                    .queryParam("lat", lat)
                    .queryParam("lon", lon)
                    .queryParamIfPresent("days", Optional.ofNullable(request.getDays()))
                    .queryParamIfPresent("ai", Optional.ofNullable(request.getAi()))
                    .queryParamIfPresent("units", Optional.ofNullable(request.getUnits()))
                    .queryParamIfPresent("lang", Optional.ofNullable(request.getLang()))
                    .build())
            .retrieve()
            .bodyToMono(String.class)
            .block();

    if (response == null) {
        throw new RuntimeException(
                "Weather API returned an empty response");
    }
    log.info("Weather API Raw Response: {}", response);

    ObjectMapper objectMapper = new ObjectMapper();

    WeatherResponse responsed =
            objectMapper.readValue(response, WeatherResponse.class);

    log.info("Mapped Response: {}", response);
    log.info("Weather API response received successfully");

    return responsed;
}

    public WeatherResponse getForecast(double lat, double lon, int days, boolean ai) {

        WeatherResponse response = weatherWebClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/forecast")
                        .queryParam("lat", lat)
                        .queryParam("lon", lon)
                        .queryParam("days", days)
                        .queryParam("ai", ai)
                        .build())
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .block();

        log.info("Forecast response: {}", response);

        return response;
    }

    public WeatherResponse getCurrentWeather(double lat, double lon, boolean ai, String units, String lang) {

        WeatherResponse response = weatherWebClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/current")
                        .queryParam("lat", lat)
                        .queryParam("lon", lon)
                        .queryParam("ai", ai)
                        .queryParam("units", units)
                        .queryParam("lang", lang)
                        .build())
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .block();
      return response;
    }

    public WeatherResponse getHourlyWeather(double lat, double lon, int days, boolean ai, String units) {
        return weatherWebClient
                .get()
                .uri(uri -> uri
                        .path("/v1/hourly")
                        .queryParam("lat", lat)
                        .queryParam("lon", lon)
                        .queryParam("days", days)
                        .queryParam("ai", ai)
                        .queryParam("units", units)
                        .build())
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .block();
    }

    public WeatherResponse getDailyWeather(double lat, double lon, int days, boolean ai, String units) {
        return weatherWebClient
                .get()
                .uri(uri -> uri
                        .path("/v1/daily")
                        .queryParam("lat", lat)
                        .queryParam("lon", lon)
                        .queryParam("days", days)
                        .queryParam("ai", ai)
                        .queryParam("units", units)
                        .build())
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .block();
    }
}
