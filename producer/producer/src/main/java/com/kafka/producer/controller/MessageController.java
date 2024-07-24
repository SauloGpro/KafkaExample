package com.kafka.producer.controller;

import com.kafka.producer.controller.dto.CarOfferRequest;
import com.kafka.producer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/offer")
public class MessageController {

    @Autowired
    private MessageService messageService;

    //Enviaremos a través de postman el coche ofertado en el formato que señalamos, hemos utilizado los especificadores de formato
    @PostMapping
    public ResponseEntity<String> createOffer(@RequestBody CarOfferRequest offerRequest) {
        String message = String.format("Brand: %s, Model: %s, Year: %d, Mileage: %d, Contact: %s, Offer: %.2f",
                offerRequest.getBrand(), offerRequest.getModel(), offerRequest.getYear(), offerRequest.getMileage(),
                offerRequest.getContactNumber(), offerRequest.getOffer());

        messageService.write(message);

        return ResponseEntity.ok("Offer sent successfully");
    }
}

