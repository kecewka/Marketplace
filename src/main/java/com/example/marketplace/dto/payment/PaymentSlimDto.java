package com.example.marketplace.dto.payment;


public class PaymentSlimDto {
    private int id;
    private double amount;

    public PaymentSlimDto(){}

    public PaymentSlimDto(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentSlimDto{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
