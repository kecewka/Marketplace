package com.example.marketplace.controller;

import com.example.marketplace.dto.exchange.ExchangeRateDTO;
import com.example.marketplace.dto.productshop.ProductShopDto;
import com.example.marketplace.entity.ProductShop1;
import com.example.marketplace.mapper.productshop.ProductShopListMapper;
import com.example.marketplace.mapper.productshop.ProductShopMapper;
import com.example.marketplace.service.productshop.ProductShopService;
import com.example.marketplace.service.scrapper.ScrapperService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductShopController {
    private final ProductShopService productShopService;
    private final ProductShopMapper productShopMapper;
    private final ProductShopListMapper productShopListMapper;
    private final ScrapperService scrapperService;

    @Autowired
    public ProductShopController(ProductShopService productShopService, ProductShopMapper productShopMapper, ProductShopListMapper productShopListMapper, ScrapperService scrapperService) {
        this.productShopService = productShopService;
        this.productShopMapper = productShopMapper;
        this.productShopListMapper = productShopListMapper;
        this.scrapperService = scrapperService;
    }

    @GetMapping("/shops/{id}")
    public List<ProductShopDto> getAllProductsAllProductsOfShop(@PathVariable int id) {
        return productShopListMapper.toDtoList(productShopService.getAllProductsAllProductsOfShop(id));
    }

    @PostMapping("/upload")
    public String uploadFiles(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "fail, empty file";
        }

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<ProductShop1> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(ProductShop1.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<ProductShop1> productShops = csvToBean.parse();

            for (ProductShop1 ps : productShops) {
                if (productShopService.getBy(ps.getShop(), ps.getProduct()) != null) {
                    productShopService.insertItems(ps.getProduct(), ps.getShop(), ps.getAmount());
                } else {
                    productShopService.addItems(ps.getProduct(), ps.getShop(), ps.getAmount());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "success";
    }


}
