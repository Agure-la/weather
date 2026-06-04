package com.example.weather.dto.response;

import lombok.Data;

@Data
public class Hourly {
    private String time;
    private Double temperature;
    private Integer precipitation_probability;
    private Double wind_speed;
    private String condition_code;
    private String icon;
    private Integer humidity;
    private Double feels_like;
    private Double wind_gust;
    private Integer uv_index;
    private String icon_path;
}
