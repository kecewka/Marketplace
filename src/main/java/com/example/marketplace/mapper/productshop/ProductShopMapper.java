package com.example.marketplace.mapper.productshop;

import com.example.marketplace.dto.productshop.ProductShopDto;
import com.example.marketplace.entity.ProductShop;
import com.example.marketplace.mapper.product.ProductMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = ProductMapper.class)
public interface ProductShopMapper {
    ProductShopMapper INSTANCE = Mappers.getMapper(ProductShopMapper.class);

    ProductShopDto productShopToDto(ProductShop productShop);
    ProductShop dtoToProduct(ProductShopDto dto);

}
