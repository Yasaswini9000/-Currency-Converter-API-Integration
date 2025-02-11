package com.example.currency_converter;



import lombok.Data;

@Data
public class ConversionResult {
    private String from;
    private String to;
    private double amount;
    private double convertedAmount;

    public ConversionResult(String from, String to, double amount, double convertedAmount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
    }
}
