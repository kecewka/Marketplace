package com.example.marketplace.controller;

import com.example.marketplace.dto.order.OrderDto;
import com.example.marketplace.dto.shop.ShopDto;
import com.example.marketplace.entity.Order;
import com.example.marketplace.mapper.order.OrderListMapper;
import com.example.marketplace.mapper.order.OrderMapper;
import com.example.marketplace.mapper.shop.ShopListMapper;
import com.example.marketplace.mapper.shop.ShopMapper;
import com.example.marketplace.service.order.OrderService;
import com.example.marketplace.service.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShopController {
    private final ShopService shopService;
    private final ShopMapper shopMapper;
    private final ShopListMapper shopListMapper;
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final OrderListMapper orderListMapper;

    @Autowired
    public ShopController(ShopService shopService, ShopMapper shopMapper, ShopListMapper shopListMapper, OrderService orderService, OrderMapper orderMapper, OrderListMapper orderListMapper) {
        this.shopService = shopService;
        this.shopMapper = shopMapper;
        this.shopListMapper = shopListMapper;
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.orderListMapper = orderListMapper;
    }

    @GetMapping("/shops")
    public List<ShopDto> getShops(){
        return shopListMapper.toDtoList(shopService.getAllShops());
    }

    @GetMapping("/shops/{id}")
    public ShopDto getShop(@PathVariable int id){
        return shopMapper.shopToDto(shopService.getShopById(id));
    }

    @GetMapping("shops/{id}/orders")
    public List<OrderDto> getOrdersList(@PathVariable int id){
        return orderListMapper.toDtoList(orderService.findOrdersOfShop(id));
    }

    @PostMapping("/shops/{id}/orders")
    public OrderDto approveOrder(@PathVariable int id, @RequestBody Order order){
        return orderMapper.orderToDto(orderService.approveOrder(id, order.getId()));
    }
}
