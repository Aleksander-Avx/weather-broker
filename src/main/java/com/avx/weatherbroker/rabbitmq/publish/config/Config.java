package com.avx.weatherbroker.rabbitmq.publish.config;

import com.avx.weatherbroker.rabbitmq.publish.Producer;
import com.avx.weatherbroker.rabbitmq.subscribe.Receiver;
import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value("${fanout.name}")
    private String fanoutName;

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(fanoutName);
    }

    @Bean
    public Queue deleteQueue1() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding1(FanoutExchange fanout, Queue deleteQueue1) {
        return BindingBuilder.bind(deleteQueue1).to(fanout);
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }

    @Bean
    public Producer producer() {
        return new Producer();
    }

}