package com.example.marketplace.service.order;


import com.example.marketplace.dao.OrderRepository;
import com.example.marketplace.entity.Order;
import com.example.marketplace.entity.Payment;
import com.example.marketplace.entity.Product;
import com.example.marketplace.enums.OrderStatus;
import com.example.marketplace.enums.PaymentStatus;
import com.example.marketplace.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final PaymentService paymentService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, PaymentService paymentService) {
        this.orderRepository = orderRepository;
        this.paymentService = paymentService;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Order getOrderById(int id) {
        Order order = null;
        Optional<Order> optional = orderRepository.findById(id);
        if (optional.isPresent()) {
            order = optional.get();
        }
        return order;
    }

    @Override
    public void saveOrder(Order order) {
        double amount = calculateAmount(order);
        Payment payment = new Payment(0, amount, null, PaymentStatus.NOT_APPROVED, null, null);
        order.setPayment(payment);
        orderRepository.save(order);
    }

    @Override
    public Order cancelOrder(int id) {
        orderRepository.cancelOrder(id);
        return getOrderById(id);
    }

    @Override
    public List<Order> findOrdersOfShop(int id) {
        return orderRepository.findOrdersOfShop(id);
    }

    @Override
    public Order approveOrder(int shopId, int orderId) {
        orderRepository.approveOrder(shopId, orderId);
        return getOrderById(orderId);
    }

    @Override
    public Order changeOrderStatus(int orderId, OrderStatus status) {
        orderRepository.changeOrderStatus(orderId, status);
        return getOrderById(orderId);
    }

    private double calculateAmount(Order order){
        double amount = 0;
        for (Product p : order.getProductList()){
            amount += p.getPrice();
        }
        return amount;
    }

}
