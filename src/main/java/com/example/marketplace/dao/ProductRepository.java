package com.example.marketplace.dao;

import com.example.marketplace.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
