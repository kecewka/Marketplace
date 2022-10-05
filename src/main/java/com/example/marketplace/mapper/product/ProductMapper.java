package com.example.marketplace.mapper.product;

import com.example.marketplace.dto.product.ProductDto;
import com.example.marketplace.dto.product.ProductPostDto;
import com.example.marketplace.dto.product.ProductSlimDto;
import com.example.marketplace.entity.Product;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto productToDto(Product product);
    ProductSlimDto productToSlimDto(Product product);
    Product dtoToProduct(ProductPostDto dto);
}
