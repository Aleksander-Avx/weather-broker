package com.avx.weatherbroker.service;

import com.avx.weatherbroker.entity.WeatherEntity;
import com.avx.weatherbroker.repository.WeatherRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WeatherClientReceiverServiceImpl implements WeatherClientReceiverService {

    private final WeatherRepository weatherRepository;
    private final ObjectMapper objectMapper;

    @Transactional
    public void getInfoFromTopic(String topicInfo) throws JsonProcessingException {
        WeatherEntity weatherEntity = objectMapper.readValue(topicInfo, WeatherEntity.class);
        weatherRepository.save(weatherEntity);
    }
}