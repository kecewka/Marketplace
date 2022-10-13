package com.example.marketplace.controller;

import com.example.marketplace.dto.order.OrderDto;
import com.example.marketplace.dto.shop.ShopDto;
import com.example.marketplace.enums.OrderStatus;
import com.example.marketplace.mapper.order.OrderListMapper;
import com.example.marketplace.mapper.order.OrderMapper;
import com.example.marketplace.mapper.shop.ShopListMapper;
import com.example.marketplace.mapper.shop.ShopMapper;
import com.example.marketplace.service.order.OrderService;
import com.example.marketplace.service.shop.ShopService;
import com.example.marketplace.service.sms.SmsService;
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
    private final SmsService smsService;

    @Autowired
    public ShopController(ShopService shopService, ShopMapper shopMapper, ShopListMapper shopListMapper, OrderService orderService, OrderMapper orderMapper, OrderListMapper orderListMapper, SmsService smsService) {
        this.shopService = shopService;
        this.shopMapper = shopMapper;
        this.shopListMapper = shopListMapper;
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.orderListMapper = orderListMapper;
        this.smsService = smsService;
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

    @PostMapping("/shops/{id}/orders/{orderId}")
    public OrderDto changeOrderStatus(@PathVariable int id, @PathVariable int orderId, @RequestParam("status") OrderStatus status){
        if (status == OrderStatus.VERIFIED){
            smsService.sendSms("+77779066364");
        }
        return orderMapper.orderToDto(orderService.changeOrderStatus(orderId, status));

        //sms service usage
    }

}
