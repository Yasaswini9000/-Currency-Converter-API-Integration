package com.example.currency_converter;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CurrencyServiceTest {

    @Test
    public void testConvertCurrency() {
        CurrencyService service = new CurrencyService();
        double result = service.convertCurrency("USD", "EUR", 100);
        assertTrue(result > 0);
    }
}
