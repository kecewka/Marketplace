package com.example.marketplace.service.payment;

import com.example.marketplace.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();
    Payment getPaymentById(int id);
    void savePayment(Payment Payment);
    void cancelPayment(int id);
}
