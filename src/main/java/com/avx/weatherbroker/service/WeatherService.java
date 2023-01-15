package com.avx.weatherbroker.service;

import com.avx.weatherbroker.entity.WeatherEntity;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface WeatherService {

    void getWeather(String city) throws JsonProcessingException;

    WeatherEntity getInfo(String city);
}
