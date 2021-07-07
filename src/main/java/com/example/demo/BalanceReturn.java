package com.example.demo;

public class BalanceReturn {
    Long amount ; //total amount
    Integer number; //emi number left

    public BalanceReturn(){
        super();
    }
    public BalanceReturn(Long amount, Integer number) {
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
