package com.example.weather.controller;

import com.example.weather.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/alerts")
public class AlertController {
    private final AlertService alertService;

//    @GetMapping
//    public List<AlertResponse> alerts() {
//
//        return alertService.findAll();
//    }
}
