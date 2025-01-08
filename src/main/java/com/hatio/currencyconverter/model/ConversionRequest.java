package com.hatio.currencyconverter.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request to convert an amount from one currency to another")
public class ConversionRequest {
    @Schema(description = "Source currency", example = "EUR")
    private String from;

    @Schema(description = "Target currency", example = "INR")
    private String to;

    @Schema(description = "Amount to be converted", example = "100")
    private double amount;

    public ConversionRequest(String from,String to,double amount){
        this.from=from;
        this.to=to;
        this.amount=amount;
    }

    public void setFrom(String from){
        this.from=from;
    }

    public void setTo(String to){
        this.to=to;
    }

    public void setAmount(double amount){
        this.amount=amount;
    }

    public String getFrom() {
        return this.from;
    }

    
    public String getTo() {
        return this.to;
    }

    public double getAmount(){
        return this.amount;
    }
}

