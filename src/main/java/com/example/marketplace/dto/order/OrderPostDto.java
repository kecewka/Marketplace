package com.example.marketplace.dto.order;


import com.example.marketplace.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class OrderPostDto {
    private int id;
    private OrderStatus status;
    private int userId;
    private LocalDateTime orderTime;
    private List<Integer> productIds;

    public OrderPostDto(){}

    public OrderPostDto(int id, OrderStatus status, int userId, LocalDateTime orderTime, List<Integer> productIds) {
        this.id = id;
        this.status = status;
        this.userId = userId;
        this.orderTime = orderTime;
        this.productIds = productIds;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }

    @Override
    public String toString() {
        return "OrderPostDto{" +
                "id=" + id +
                ", status=" + status +
                ", userId=" + userId +
                ", orderTime=" + orderTime +
                ", productIds=" + productIds +
                '}';
    }


}
