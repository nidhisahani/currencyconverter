package com.hatio.currencyconverter.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hatio.currencyconverter.model.ConversionRequest;
import com.hatio.currencyconverter.service.CurrencyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @Operation(summary = "Fetch exchange rates for a given base currency")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully fetched exchange rates",
                content = {@Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "400", description = "Invalid base currency provided",
                content = @Content),
        @ApiResponse(responseCode = "500", description = "External API unavailable",
                content = @Content)
    })
    @GetMapping("/rates")
    public Map<String, Object> getExchangeRates(
            @RequestParam(value = "base", defaultValue = "EUR") String base) {
        return currencyService.getExchangeRates(base);
    }

    @Operation(summary = "Convert an amount from one currency to another")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully converted currency",
                content = {@Content(mediaType = "application/json",
                        schema = @Schema(implementation = Map.class))}),
        @ApiResponse(responseCode = "400", description = "Invalid currency codes provided",
                content = @Content),
        @ApiResponse(responseCode = "500", description = "External API unavailable",
                content = @Content)
    })
    @PostMapping("/convert")
    public Map<String, Object> convertCurrency(@RequestBody ConversionRequest request) {
        return currencyService.convertCurrency(request);
    }
}
