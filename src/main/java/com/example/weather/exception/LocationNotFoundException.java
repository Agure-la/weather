package com.example.weather.exception;

public class LocationNotFoundException extends RuntimeException{
    public LocationNotFoundException(
            String id) {

        super("Location not found: " + id);
    }
}
