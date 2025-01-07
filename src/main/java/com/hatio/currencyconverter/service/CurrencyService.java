package com.hatio.currencyconverter.service;



import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hatio.currencyconverter.exception.CustomException;
import com.hatio.currencyconverter.model.ConversionRequest;

@Service
public class CurrencyService {

    @Value("${exchange.api.url}")
    private String apiUrl;

    @Value("${exchange.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> getExchangeRates(String base) {
        try {
            String url = apiUrl + "?access_key=" + apiKey + "&base=" + base;
            return restTemplate.getForObject(url, Map.class);
        } catch (Exception e) {
            throw new CustomException("Failed to fetch exchange rates");
        }
    }

    public Map<String, Object> convertCurrency(ConversionRequest request) {
        Map<String, Object> rates = getExchangeRates(request.getFrom());
        if (!rates.containsKey("rates")) {
            throw new CustomException("Invalid base currency");
        }

        Map<String, Double> exchangeRates = (Map<String, Double>) rates.get("rates");
        Double conversionRate = exchangeRates.get(request.getTo());
        if (conversionRate == null) {
            throw new CustomException("Invalid target currency");
        }

        double convertedAmount = request.getAmount() * conversionRate;
        return Map.of(
            "from", request.getFrom(),
            "to", request.getTo(),
            "amount", request.getAmount(),
            "convertedAmount", convertedAmount
        );
    }
}

