package com.example.weather.dto.response;

import lombok.Data;

@Data
public class Current {
    private String time;
    private Double temperature;
    private Double wind_speed;
    private Integer wind_direction;
    private String condition_code;
    private String icon;
    private String icon_path;
}
