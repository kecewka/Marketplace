package com.example.marketplace;

import com.example.marketplace.dao.ProductRepository;
import com.example.marketplace.entity.Category;
import com.example.marketplace.entity.Product;
import com.example.marketplace.service.product.ProductService;
import com.example.marketplace.service.product.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class Tests {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void productExists() {
        List<Product> products = getProducts();
        Mockito.lenient().when(productRepository.findAll()).thenReturn(products);
        List<Product> res = productService.getAllProducts();

        Assertions.assertNotNull(res);
    }

    private List<Product> getProducts(){
        List<Category> ctg = new ArrayList<>();
        Product product = new Product(0, "asd", ctg, 12345);
        List<Product> products = new ArrayList<>();
        products.add(product);
        return products;
    }
}
