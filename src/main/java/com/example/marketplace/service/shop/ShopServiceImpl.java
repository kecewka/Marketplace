package com.example.marketplace.service.shop;

import com.example.marketplace.dao.ShopRepository;
import com.example.marketplace.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    @Override
    public Shop getShopById(int id) {
        Shop shop = null;
        Optional<Shop> optional = shopRepository.findById(id);
        if (optional.isPresent()) {
            shop = optional.get();
        }
        return shop;
    }

    @Override
    public void saveShop(Shop shop) {
        shopRepository.save(shop);

    }

    @Override
    public void deleteShop(int id) {
        shopRepository.deleteById(id);
    }
}
