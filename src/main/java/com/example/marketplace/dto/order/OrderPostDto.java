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
    private int shopId;

    public OrderPostDto(){}

//    public OrderPostDto(int id, OrderStatus status, int userId, LocalDateTime orderTime, List<Integer> productIds, int shop) {
//        this.id = id;
//        this.status = OrderStatus.CREATED;
//        this.userId = userId;
//        this.orderTime = LocalDateTime.now();
//        this.productIds = productIds;
//        this.shopId = shop;
//    }

    public OrderPostDto(int id, int userId, List<Integer> productIds, int shop){
        this.id = id;
        this.userId = userId;
        this.productIds = productIds;
        this.shopId = shop;
        this.status = OrderStatus.CREATED;
        this.orderTime = LocalDateTime.now();
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

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "OrderPostDto{" +
                "id=" + id +
                ", status=" + status +
                ", userId=" + userId +
                ", orderTime=" + orderTime +
                ", productIds=" + productIds +
                ", shopId=" + shopId +
                '}';
    }


}
