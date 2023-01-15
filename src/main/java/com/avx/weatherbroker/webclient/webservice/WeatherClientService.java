package com.avx.weatherbroker.webclient.webservice;

import com.avx.weatherbroker.webclient.dtowebclient.OpenWeatherDto;

public interface WeatherClientService {

    OpenWeatherDto getWeatherForCity(String city);
}
