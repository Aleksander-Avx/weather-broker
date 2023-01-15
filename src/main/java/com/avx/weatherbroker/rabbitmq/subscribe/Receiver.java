package com.avx.weatherbroker.rabbitmq.subscribe;

import com.avx.weatherbroker.service.WeatherClientReceiverService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class Receiver {

    @Autowired
    private WeatherClientReceiverService weatherClientReceiverService;

    @RabbitListener(queues = "#{deleteQueue1.name}")
    public void receive(String result) throws JsonProcessingException {
        weatherClientReceiverService.getInfoFromTopic(result);
    }

}