package com.example.marketplace.service.order;

import com.example.marketplace.dto.order.OrderDto;
import com.example.marketplace.entity.Order;
import com.example.marketplace.enums.OrderStatus;
import com.example.marketplace.enums.PaymentStatus;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(int id);
    void saveOrder(Order order);
    Order cancelOrder(int id);
    List<Order> findOrdersOfShop(int id);
    Order approveOrder(int shopId, int orderId);

    Order changeOrderStatus(int orderId, OrderStatus status);
}
