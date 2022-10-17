package com.example.marketplace.service.order;


import com.example.marketplace.dao.OrderRepository;
import com.example.marketplace.dao.ShopRepository;
import com.example.marketplace.dao.UserRepository;
import com.example.marketplace.entity.*;
import com.example.marketplace.enums.OrderStatus;
import com.example.marketplace.enums.PaymentStatus;
import com.example.marketplace.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final UserRepository userRepository;
    private final ShopRepository shopRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, PaymentService paymentService, UserRepository userRepository, ShopRepository shopRepository) {
        this.orderRepository = orderRepository;
        this.paymentService = paymentService;
        this.userRepository = userRepository;
        this.shopRepository = shopRepository;
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

        if (checkUser(id)) {
            return orderRepository.findOrdersOfShop(id);
        } else {
            throw new AccessDeniedException("not your shop");
        }

    }

    public boolean checkUser(int id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = null;
        Optional<User> optional = userRepository.findByUsername(username);
        if (optional.isPresent()) {
            user = optional.get();
        }
        Shop shop = null;
        Optional<Shop> shopOptional = shopRepository.findById(id);
        if (shopOptional.isPresent()) {
            shop = shopOptional.get();
        }
        if (shop.getUser().equals(user)) {
            return true;
        }
        return false;
    }

    @Override
    public Order changeOrderStatus(int orderId, OrderStatus status) {
        if (checkUser(getOrderById(orderId).getShop().getId())) {
            orderRepository.changeOrderStatus(orderId, status);
            return getOrderById(orderId);
        } else {
            throw new AccessDeniedException("not your shop");
        }
    }

    private double calculateAmount(Order order) {
        double amount = 0;
        for (Product p : order.getProductList()) {
            amount += p.getPrice();
        }
        return amount;
    }

}
