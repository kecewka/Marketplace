package com.example.marketplace.service.productshop;

import com.example.marketplace.dao.ProductRepository;
import com.example.marketplace.dao.ProductShopRepository;
import com.example.marketplace.entity.ProductShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
