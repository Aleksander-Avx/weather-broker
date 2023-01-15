package com.avx.weatherbroker.mapper;

import com.avx.weatherbroker.entity.WeatherEntity;
import com.avx.weatherbroker.webclient.dtowebclient.OpenWeatherDto;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {

    public WeatherEntity dtoConversionToEntity(OpenWeatherDto openWeatherDto) {

        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setHumidity(openWeatherDto.getMain().getHumidity());
        weatherEntity.setWindSpeed(openWeatherDto.getWind().getSpeed());
        weatherEntity.setCounty(openWeatherDto.getSys().getCountry());
        weatherEntity.setTemperature(openWeatherDto.getMain().getTemp());
        weatherEntity.setPressure(openWeatherDto.getMain().getPressure());
        weatherEntity.setCity(openWeatherDto.getName());

        return weatherEntity;
    }
}
