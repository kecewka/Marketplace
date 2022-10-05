package com.example.marketplace.controller;

import com.example.marketplace.dto.productshop.ProductShopDto;
import com.example.marketplace.mapper.productshop.ProductShopListMapper;
import com.example.marketplace.mapper.productshop.ProductShopMapper;
import com.example.marketplace.service.productshop.ProductShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductShopController {
    private final ProductShopService productShopService;
    private final ProductShopMapper productShopMapper;
    private final ProductShopListMapper productShopListMapper;

    @Autowired
    public ProductShopController(ProductShopService productShopService, ProductShopMapper productShopMapper, ProductShopListMapper productShopListMapper) {
        this.productShopService = productShopService;
        this.productShopMapper = productShopMapper;
        this.productShopListMapper = productShopListMapper;
    }

    @GetMapping("/shops/{id}")
    public List<ProductShopDto> getAllProductsAllProductsOfShop(@PathVariable int id) {
        return productShopListMapper.toDtoList(productShopService.getAllProductsAllProductsOfShop(id));
    }
}
