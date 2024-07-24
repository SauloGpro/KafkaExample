package com.kafka.producer.service.impl;

import com.kafka.producer.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private KafkaTemplate<String, String> kafkaTemplate;

    //Conectamos al servicio con kafka y enviamos el mensaje al topic
    @Override
    public void write(String message) {
        kafkaTemplate.send("car-sales", message);
    }
}

