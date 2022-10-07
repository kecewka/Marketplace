package com.example.marketplace.mapper.shop;

import com.example.marketplace.dto.shop.ShopDto;
import com.example.marketplace.entity.Shop;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import javax.persistence.criteria.CriteriaBuilder;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ShopMapper {
    ShopDto shopToDto(Shop shop);
}
