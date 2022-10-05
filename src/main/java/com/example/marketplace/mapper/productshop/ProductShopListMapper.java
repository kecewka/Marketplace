package com.example.marketplace.mapper.productshop;

import com.example.marketplace.dto.productshop.ProductShopDto;
import com.example.marketplace.entity.Product;
import com.example.marketplace.entity.ProductShop;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductShopMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductShopListMapper {

    List<ProductShopDto> toDtoList(List<ProductShop> productShops);

}
