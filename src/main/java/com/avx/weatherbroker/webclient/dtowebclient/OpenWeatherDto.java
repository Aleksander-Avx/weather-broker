package com.avx.weatherbroker.webclient.dtowebclient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherDto {

    private OpenWeatherMainDto main;

    private OpenWeatherSysDto sys;

    private OpenWeatherWindDto wind;

    private String name;

}
