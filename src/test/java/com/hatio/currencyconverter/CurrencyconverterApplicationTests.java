package com.hatio.currencyconverter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hatio.currencyconverter.service.CurrencyService;

@SpringBootTest
class CurrencyconverterApplicationTests {

	 private final CurrencyService currencyService = new CurrencyService();

    @Test
    public void testGetExchangeRates() {
        assertNotNull(currencyService.getExchangeRates("EUR"));
    }

}