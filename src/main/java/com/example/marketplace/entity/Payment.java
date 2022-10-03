package com.example.marketplace.entity;

import com.example.marketplace.enums.PaymentStatus;
import com.example.marketplace.enums.PaymentType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private double amount;
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentType paymentType;
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;
    @Column(name = "payment_time")
    private LocalDateTime paymentTime;


    @OneToOne(mappedBy = "payment")
//    @JoinTable(name = "order_payment"
//            ,joinColumns = @JoinColumn(name = "payment_id")
//            ,inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Order order;


    public Payment(){}

    public Payment(int id, double amount, PaymentType paymentType, PaymentStatus paymentStatus, LocalDateTime paymentTime, Order order) {
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentType=" + paymentType +
                ", paymentStatus=" + paymentStatus +
                ", paymentTime=" + paymentTime +
                ", order=" + order +
                '}';
    }


}
