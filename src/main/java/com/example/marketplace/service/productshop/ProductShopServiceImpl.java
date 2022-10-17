package com.example.marketplace.service.productshop;

import com.example.marketplace.dao.ProductRepository;
import com.example.marketplace.dao.ProductShopRepository;
import com.example.marketplace.entity.Order;
import com.example.marketplace.entity.ProductShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductShopServiceImpl implements ProductShopService {

    private final ProductShopRepository productRepository;

    @Autowired
    public ProductShopServiceImpl(ProductShopRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductShop> getAllProductsAllProductsOfShop(int id) {
        return productRepository.findAllProductsOfShop(id);
    }

    public ProductShop getBy(int id, int pid) {
        if (productRepository.findProductById(id, pid) != null) {
            return productRepository.findProductById(id, pid);
        } else {
            return null;
        }
    }

    public void insertItems(int pid, int id, int amount){
        productRepository.insertItems(pid, id, amount);
    }

    public void addItems(int pid, int id, int amount){
        productRepository.addItems(pid, id, amount);
    }
}

