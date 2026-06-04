package com.example.weather.dto.response;

import lombok.Data;

@Data
public class Location {
    private Double lat;
    private Double lon;
    private String timezone;
    private Double requested_lat;
    private Double requested_lon;
    private String country;
}
