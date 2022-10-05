package com.example.marketplace.mapper.product;

import com.example.marketplace.dto.product.ProductDto;
import com.example.marketplace.entity.Product;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductListMapper {
    List<ProductDto> toDtoList(List<Product> products);
}
