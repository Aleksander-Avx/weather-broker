package com.avx.weatherbroker.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface WeatherClientReceiverService {

    public void getInfoFromTopic(String topicInfo) throws JsonProcessingException;
}
