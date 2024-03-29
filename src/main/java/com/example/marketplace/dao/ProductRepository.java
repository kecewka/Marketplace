package com.example.marketplace.dao;

import com.example.marketplace.entity.Product;
import com.example.marketplace.entity.ProductShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
