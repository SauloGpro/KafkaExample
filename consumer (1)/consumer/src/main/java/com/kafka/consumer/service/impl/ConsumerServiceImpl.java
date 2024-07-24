package com.kafka.consumer.service.impl;

import com.kafka.consumer.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerServiceImpl implements ConsumerService {

        //Al consumidor le indicamos el topic que tiene que escuchar y le pasamos la variable message que seria el coche
    @KafkaListener(topics = "car-sales")
    public void consume(String message) {
        log.info("Sales received -> {}", message);

    }
}
