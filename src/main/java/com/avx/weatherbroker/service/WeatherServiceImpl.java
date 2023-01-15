package com.avx.weatherbroker.service;

import com.avx.weatherbroker.entity.WeatherEntity;
import com.avx.weatherbroker.mapper.WeatherMapper;
import com.avx.weatherbroker.rabbitmq.publish.Producer;
import com.avx.weatherbroker.repository.WeatherRepository;
import com.avx.weatherbroker.webclient.dtowebclient.OpenWeatherDto;
import com.avx.weatherbroker.webclient.webservice.WeatherClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

@Slf4j
@RequiredArgsConstructor
@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherClientService weatherClient;
    private final WeatherRepository weatherRepository;
    private final WeatherMapper weatherMapper;
    private final Producer rabbitProducer;
    private final ObjectMapper objectMapper;

    @Override
    public void getWeather(String city) throws JsonProcessingException {

        log.info("LOGGER: weather-broker -> openweather (CHECK_PARAMETR_WITH_CITY)");
        OpenWeatherDto weatherForCity = null;
        try {
            weatherForCity = weatherClient.getWeatherForCity(city);
        } catch (HttpStatusCodeException e) {
            log.error("LOGGER: RestTemplate convertion false " + e.getStatusCode());
            throw new RuntimeException();
        }

        log.info("LOGGER: weather-broker <- openweather (CHECK_PARAMETR_WITH_CITY)");
        WeatherEntity weatherEntity = weatherMapper.dtoConversionToEntity(weatherForCity);
        String jsonString = objectMapper.writeValueAsString(weatherEntity);

        log.info("LOGGER: weather-broker -> RabbitMQ (getWeather)");
        rabbitProducer.sendMsg(jsonString);
    }

    @Override
    public WeatherEntity getInfo(String city) {
        return weatherRepository.getWeatherEntitiesByCity(city);
    }

}


