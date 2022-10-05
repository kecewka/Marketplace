package com.example.marketplace.dao;

import com.example.marketplace.entity.Product;
import com.example.marketplace.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

}
