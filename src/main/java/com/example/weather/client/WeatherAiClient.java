package com.example.weather.client;

import com.example.weather.dto.request.WeatherRequest;
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
public WeatherResponse getWeather(WeatherRequest request) {

    String response = weatherWebClient
            .get()
            .uri(uriBuilder -> uriBuilder
                    .path("/v1/weather")
                    .queryParam("lat", request.getLat())
                    .queryParam("lon", request.getLon())
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
}
