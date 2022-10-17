package com.example.marketplace.service.productshop;

import com.example.marketplace.entity.ProductShop;

import java.util.List;

public interface ProductShopService {
    List<ProductShop> getAllProductsAllProductsOfShop(int id);

    ProductShop getBy(int i, int i1);

    void insertItems(int pid, int id, int amount);

    void addItems(int pid, int id, int amount);
}
