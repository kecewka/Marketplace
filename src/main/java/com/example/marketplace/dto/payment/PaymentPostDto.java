package com.example.marketplace.dto.payment;

import com.example.marketplace.enums.PaymentStatus;
import com.example.marketplace.enums.PaymentType;

import java.time.LocalDateTime;

public class PaymentPostDto {
    private int id;
    private double amount;
    private PaymentType paymentType;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentTime;

    public PaymentPostDto(){}

    public PaymentPostDto(int id, double amount, PaymentType paymentType, PaymentStatus paymentStatus, LocalDateTime paymentTime) {
        this.id = id;
        this.amount = amount;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.paymentTime = paymentTime;
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

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    @Override
    public String toString() {
        return "PaymentPostDto{" +
                "id=" + id +
                ", amount=" + amount +
                ", paymentType=" + paymentType +
                ", paymentStatus=" + paymentStatus +
                ", paymentTime=" + paymentTime +
                '}';
    }
}
