package com.example.demo;

public class Lump {
    Long amount ; //amount 
    Integer number; //emi no.

    public Lump(){
        super();
    }
    public Lump(Long amount, Integer number) {
        this.amount = amount;
        this.number = number;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    
    
}
