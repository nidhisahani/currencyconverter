package com.hatio.currencyconverter.model;

public class ConversionRequest {
    private String from;
    private String to;
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

