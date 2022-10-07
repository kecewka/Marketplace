package com.example.marketplace.dao;

import com.example.marketplace.entity.Product;
import com.example.marketplace.entity.ProductShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductShopRepository extends JpaRepository<ProductShop, Integer> {
    @Query(value = "SELECT p from ProductShop p  where p.shop.id = :id and p.amount > 0")
    List<ProductShop> findAllProductsOfShop(int id);
}
