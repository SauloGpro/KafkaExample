package com.kafka.producer.controller.dto;

import lombok.Data;

@Data
public class CarOfferRequest {
    private String brand;
    private String model;
    private int year;
    private int mileage;
    private String contactNumber;
    private double offer;


}
