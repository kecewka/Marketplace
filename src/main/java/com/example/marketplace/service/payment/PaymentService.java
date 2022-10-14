package com.example.marketplace.service.payment;

import com.example.marketplace.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();
    Payment getPaymentById(int id);
    void savePayment(Payment payment);
    void cancelPayment(int id);

    void makePayment(Payment payment);
}
