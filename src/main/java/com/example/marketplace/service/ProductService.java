package com.example.marketplace.service;

import com.example.marketplace.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    void saveProduct(Product product);
    void deleteProduct(int id);
}
