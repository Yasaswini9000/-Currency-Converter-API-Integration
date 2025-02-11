package com.example.currency_converter;


import lombok.Data;

@Data
public class ConversionRequest {
    private String from;
    private String to;
    private double amount;
}
