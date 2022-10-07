package com.example.marketplace.dto.order;

import com.example.marketplace.dto.payment.PaymentSlimDto;
import com.example.marketplace.dto.product.ProductSlimDto;
import com.example.marketplace.dto.user.UserSlimDto;
import com.example.marketplace.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {
    private int id;
    private OrderStatus status;
    private List<ProductSlimDto> productList;
    private UserSlimDto user;
    private LocalDateTime orderTime;

    private PaymentSlimDto payment;


    public OrderDto(){}

    public OrderDto(int id, OrderStatus status, List<ProductSlimDto> productList, UserSlimDto user, LocalDateTime orderTime, PaymentSlimDto payment) {
        this.id = id;
        this.status = status;
        this.productList = productList;
        this.user = user;
        this.orderTime = orderTime;
        this.payment = payment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<ProductSlimDto> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductSlimDto> productList) {
        this.productList = productList;
    }

    public UserSlimDto getUser() {
        return user;
    }

    public void setUser(UserSlimDto user) {
        this.user = user;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public PaymentSlimDto getPayment() {
        return payment;
    }

    public void setPayment(PaymentSlimDto payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", status=" + status +
                ", productList=" + productList +
                ", user=" + user +
                ", orderTime=" + orderTime +
                ", payment=" + payment +
                '}';
    }
}
