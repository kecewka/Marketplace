package com.example.marketplace.controller;

import com.example.marketplace.dto.payment.PaymentDto;
import com.example.marketplace.dto.payment.PaymentPostDto;
import com.example.marketplace.enums.OrderStatus;
import com.example.marketplace.enums.PaymentStatus;
import com.example.marketplace.mapper.payment.PaymentListMapper;
import com.example.marketplace.mapper.payment.PaymentMapper;
import com.example.marketplace.service.order.OrderService;
import com.example.marketplace.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentController {
    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;
    private final PaymentListMapper paymentListMapper;
    private final OrderService orderService;

    @Autowired
    public PaymentController(PaymentService paymentService, PaymentMapper paymentMapper, PaymentListMapper paymentListMapper, OrderService orderService) {
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
        this.paymentListMapper = paymentListMapper;
        this.orderService = orderService;
    }

    @GetMapping("/payments")
    public List<PaymentDto> getAllPayments() {
        return paymentListMapper.toDtoList(paymentService.getAllPayments());
    }

    @GetMapping("/payments/{id}")
    public PaymentDto getPayment(@PathVariable int id) {
        return paymentMapper.paymentToDto(paymentService.getPaymentById(id));
    }

    @PostMapping("/payments")
    public PaymentDto makePayment(@RequestBody PaymentPostDto dto) {
        paymentService.makePayment(paymentMapper.dtoToPayment(dto));
        if(dto.getPaymentStatus() == PaymentStatus.APPROVED){
            orderService.changeOrderStatus(
                    paymentService.getPaymentById(dto.getId())
                    .getOrder()
                    .getId(), OrderStatus.PAID
            );
        }
        else{
            orderService.changeOrderStatus(
                    paymentService.getPaymentById(dto.getId())
                    .getOrder()
                    .getId(), OrderStatus.CANCELLED
            );
        }
        return paymentMapper.paymentToDto(paymentService.getPaymentById(dto.getId()));
    }
}
