package com.avx.weatherbroker.rabbitmq.publish;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class Producer {

    @Autowired
    private FanoutExchange exchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void sendMsg(String weatherEntity) {
        rabbitTemplate.convertAndSend(exchange.getName(), "", weatherEntity.toString());
    }

}