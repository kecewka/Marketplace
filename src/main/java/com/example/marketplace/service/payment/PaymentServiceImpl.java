package com.example.marketplace.service.payment;


import com.example.marketplace.dao.PaymentRepository;
import com.example.marketplace.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(int id) {
        Payment payment = null;
        Optional<Payment> optional = paymentRepository.findById(id);
        if (optional.isPresent()) {
            payment = optional.get();
        }
        return payment;
    }

    @Override
    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void cancelPayment(int id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public void makePayment(Payment payment) {
        paymentRepository.makePayment(payment.getId(), payment.getPaymentStatus(), payment.getPaymentTime(), payment.getPaymentType());
    }
}
