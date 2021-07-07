package com.example.demo;

public class Bank {

    String name;
    Long amount;
    int rate;
    int time;

    public Bank(String name, Long amount, int rate, int time) {
        this.name = name;
        this.amount = amount;
        this.rate = rate;
        this.time = time;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getAmount() {
        return amount;
    }
    public void setAmount(Long amount) {
        this.amount = amount;
    }
    public int getRate() {
        return rate;
    }
    public void setRate(int rate) {
        this.rate = rate;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
}
