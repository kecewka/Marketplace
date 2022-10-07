package com.example.marketplace.mapper.shop;

import com.example.marketplace.dto.shop.ShopDto;
import com.example.marketplace.entity.Shop;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ShopMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ShopListMapper {
    List<ShopDto> toDtoList(List<Shop> shops);
}
