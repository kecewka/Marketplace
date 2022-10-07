package com.example.marketplace.mapper.order;

import com.example.marketplace.dto.order.OrderDto;
import com.example.marketplace.entity.Order;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = OrderMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderListMapper {

    List<OrderDto> toDtoList(List<Order> orders);
}
