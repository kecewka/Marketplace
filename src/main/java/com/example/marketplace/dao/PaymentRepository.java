package com.example.marketplace.dao;

import com.example.marketplace.entity.Payment;
import com.example.marketplace.enums.PaymentStatus;
import com.example.marketplace.enums.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    @Modifying
    @Transactional
    @Query(value = "update Payment p set p.paymentStatus = :paymentStatus, p.paymentTime = :paymentTime, p.paymentType = :paymentType where p.id = :id")
    void makePayment(int id, PaymentStatus paymentStatus, LocalDateTime paymentTime, PaymentType paymentType);
}
