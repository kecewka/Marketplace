package com.example.marketplace.service.order;

import com.example.marketplace.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(int id);
    void saveOrder(Order order);
    Order cancelOrder(int id);
}
