package com.hatio.currencyconverter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hatio.currencyconverter.model.ConversionRequest;
import com.hatio.currencyconverter.service.CurrencyService;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/rates")
    public ResponseEntity<?> getExchangeRates(@RequestParam(defaultValue = "USD") String base) {
        return ResponseEntity.ok(currencyService.getExchangeRates(base));
    }

    @PostMapping("/convert")
    public ResponseEntity<?> convertCurrency(@RequestBody ConversionRequest request) {
        return ResponseEntity.ok(currencyService.convertCurrency(request));
    }
}
