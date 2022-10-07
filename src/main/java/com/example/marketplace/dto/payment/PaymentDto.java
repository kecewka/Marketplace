package com.example.marketplace.dto.payment;

import com.example.marketplace.dto.order.OrderSlimDto;
import com.example.marketplace.enums.PaymentStatus;
import com.example.marketplace.enums.PaymentType;

import java.time.LocalDateTime;

public class PaymentDto {
    private int id;
    private double amount;
    private PaymentType paymentType;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentTime;
    private OrderSlimDto order;

    public PaymentDto(){}

    public PaymentDto(int id, double amount, PaymentType paymentType, PaymentStatus paymentStatus, LocalDateTime paymentTime, OrderSlimDto order) {
        this.id = id;
        this.amount = amount;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.paymentTime = paymentTime;
        this.order = order;
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

    public OrderSlimDto getOrder() {
        return order;
    }

    public void setOrder(OrderSlimDto order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "PaymentDto{" +
                "id=" + id +
                ", amount=" + amount +
                ", paymentType=" + paymentType +
                ", paymentStatus=" + paymentStatus +
                ", paymentTime=" + paymentTime +
                ", order=" + order +
                '}';
    }
}
