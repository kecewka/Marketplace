package com.example.marketplace.dao;

import com.example.marketplace.entity.Order;
import com.example.marketplace.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Modifying
    @Transactional
    @Query(value = "update Order o set o.status = 'CANCELLED' where o.id = :id")
    void cancelOrder(int id);

    @Query(value = "SELECT o from Order o where o.status = 'PAID' and o.shop.id = :id")
    List<Order> findOrdersOfShop(int id);
    @Modifying
    @Transactional
    @Query(value = "update Order o set o.status = 'VERIFIED' where o.shop.id = :shopId and o.id = :orderId")
    Order approveOrder(int shopId, int orderId);
}
