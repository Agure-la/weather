package com.example.weather.exception;

public class ResourceAlreadyExistException extends RuntimeException{
    public ResourceAlreadyExistException(String id) {
        super("Location Already Exist: " + id);
    }
}
