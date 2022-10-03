package com.example.marketplace.controller;

import com.example.marketplace.dto.product.ProductDto;
import com.example.marketplace.dto.product.ProductPostDto;
import com.example.marketplace.entity.Product;
import com.example.marketplace.mapper.ProductListMapper;
import com.example.marketplace.mapper.ProductMapper;
import com.example.marketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;
    private final ProductListMapper productListMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper, ProductListMapper productListMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
        this.productListMapper = productListMapper;
    }

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        return productListMapper.toDtoList(productService.getAllProducts());
    }

    @GetMapping("/products/{id}")
    public ProductDto getProduct(@PathVariable int id) {
        return productMapper.productToDto(productService.getProductById(id));
    }

    @PostMapping("/products")
    public Product postProduct(@RequestBody ProductPostDto productPostDto) {
        productService.saveProduct(productMapper.dtoToProduct(productPostDto));
        return productMapper.dtoToProduct(productPostDto);
    }

    @PutMapping("/products")
    public Product putProduct(@RequestBody ProductPostDto productPostDto) {
        productService.saveProduct(productMapper.dtoToProduct(productPostDto));
        return productMapper.dtoToProduct(productPostDto);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return "Product with id: " + id + " has been deleted";
    }
}
