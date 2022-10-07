package com.example.marketplace.service.shop;

import com.example.marketplace.entity.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> getAllShops();
    Shop getShopById(int id);
    void saveShop(Shop Shop);
    void deleteShop(int id);

}
