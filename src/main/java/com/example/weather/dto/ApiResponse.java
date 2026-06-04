package com.example.weather.dto;

public record ApiResponse<T> (boolean success,
String message,
T data){
}
