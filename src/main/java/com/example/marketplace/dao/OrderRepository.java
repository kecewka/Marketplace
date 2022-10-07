package com.example.marketplace.dao;

import com.example.marketplace.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Modifying
    @Transactional
    @Query(value = "update Order o set o.status = 'CANCELLED' where o.id = :id")
    void cancelOrder(int id);

}
