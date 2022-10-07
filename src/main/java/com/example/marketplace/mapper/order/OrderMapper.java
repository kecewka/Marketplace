package com.example.marketplace.mapper.order;

import com.example.marketplace.dto.order.OrderDto;
import com.example.marketplace.dto.order.OrderPostDto;
import com.example.marketplace.entity.Order;
import com.example.marketplace.entity.Product;
import com.example.marketplace.service.product.ProductService;
import com.example.marketplace.service.shop.ShopService;
import com.example.marketplace.service.user.UserService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {ProductService.class, ShopService.class, UserService.class})
public abstract class OrderMapper {
    @Autowired
    protected ProductService productService;

    public abstract OrderDto orderToDto(Order order);

    @Mapping(source = "userId", target = "user")
    @Mapping(source = "productIds", target = "productList")
    @Mapping(source = "shopId", target = "shop")
    @Mapping(target="orderTime", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target="status", expression="java(com.example.marketplace.enums.OrderStatus.CREATED)")
    public abstract Order dtoToOrder(OrderPostDto dto);

    public List<Product> integerListToProductList(List<Integer> list) {
        if ( list == null ) {
            return null;
        }

        List<Product> list1 = new ArrayList<>(list.size());
        for ( Integer integer : list ) {
            list1.add( productService.getProductById( integer.intValue() ) );
        }

        return list1;
    }
}
