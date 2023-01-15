package com.avx.weatherbroker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherDto {

    private int temperature; // температура

    private int pressure; // давление

    private int humidity; // влажность

    private float windSpeed; // скорость ветра

    private String country; // страна

    private String name; // название города
}