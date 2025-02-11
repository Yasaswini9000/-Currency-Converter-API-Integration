package com.example.currency_converter;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import java.util.Map;

@Service
public class CurrencyService {

    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public Map<String, Double> getExchangeRates(String baseCurrency) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + baseCurrency;

        try {
            // Fetch the response as ExchangeRatesResponse
            ExchangeRatesResponse response = restTemplate.getForObject(url, ExchangeRatesResponse.class);

            if (response == null || response.getRates() == null) {
                throw new CurrencyConversionException("Failed to fetch exchange rates for currency: " + baseCurrency);
            }

            return response.getRates();
        } catch (HttpClientErrorException e) {
            throw new CurrencyConversionException("External API is unavailable or returned an error: " + e.getMessage());
        } catch (Exception e) {
            throw new CurrencyConversionException("An unexpected error occurred: " + e.getMessage());
        }
    }

    public double convertCurrency(String from, String to, double amount) {
        Map<String, Double> rates = getExchangeRates(from);
        Double rate = rates.get(to);

        if (rate == null) {
            throw new CurrencyConversionException("Invalid target currency: " + to);
        }

        return amount * rate;
    }
}
