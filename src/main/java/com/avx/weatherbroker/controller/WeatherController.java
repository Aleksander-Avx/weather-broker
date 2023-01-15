package com.avx.weatherbroker.controller;

import com.avx.weatherbroker.entity.WeatherEntity;
import com.avx.weatherbroker.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather-info")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/request-weather")
    public void getWeather(@RequestParam String city) throws JsonProcessingException {
        weatherService.getWeather(city);
    }

    @GetMapping("/get-weather")
    public WeatherEntity getInfo(@RequestParam String city) {
        return weatherService.getInfo(city);
    }
}
