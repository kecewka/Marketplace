package com.example.marketplace.dao;

import com.example.marketplace.entity.Product;
import com.example.marketplace.entity.ProductShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductShopRepository extends JpaRepository<ProductShop, Integer> {
    @Query(value = "SELECT p from ProductShop p  where p.shop.id = :id and p.amount > 0")
    List<ProductShop> findAllProductsOfShop(int id);

    @Modifying
    @Transactional
    @Query(value = "update ProductShop p set p.amount = p.amount + :amount where p.product.id = :product_id and p.shop.id = :shop_id")
    void insertItems(int product_id, int shop_id, int amount);

    @Query(value = "Select p from ProductShop p where p.shop.id = :id and p.product.id = :pid")
    ProductShop findProductById(int id, int pid);

    @Modifying
    @Transactional
    @Query(value = "insert into product_shop (product_id, shop_id, amount) values (:pid, :id, :amount)", nativeQuery = true)
    void addItems(int pid, int id, int amount);

}
