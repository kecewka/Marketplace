package com.example.marketplace.controller;

import com.example.marketplace.dto.order.OrderDto;
import com.example.marketplace.dto.order.OrderPostDto;
import com.example.marketplace.entity.Order;
import com.example.marketplace.mapper.order.OrderListMapper;
import com.example.marketplace.mapper.order.OrderMapper;
import com.example.marketplace.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final OrderListMapper orderListMapper;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper, OrderListMapper orderListMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.orderListMapper = orderListMapper;
    }

    @GetMapping("/orders")
    public List<OrderDto> getAllOrders() { return orderListMapper.toDtoList(orderService.getAllOrders()); }

    @GetMapping("/orders/{id}")
    public OrderDto getOrder(@PathVariable int id) { return orderMapper.orderToDto(orderService.getOrderById(id)); }

    @PostMapping("/orders")
    public OrderDto postOrder(@RequestBody OrderPostDto orderPostDto){
        orderService.saveOrder(orderMapper.dtoToOrder(orderPostDto));
        return orderMapper.orderToDto(orderMapper.dtoToOrder(orderPostDto));
    }

    @PutMapping("/orders")
    public Order putOrder(@RequestBody OrderPostDto orderPostDto){
        orderService.saveOrder(orderMapper.dtoToOrder(orderPostDto));
        return orderMapper.dtoToOrder(orderPostDto);
    }

    @DeleteMapping("/orders/{id}")
    public OrderDto cancelOrder(@PathVariable int id){
        return orderMapper.orderToDto(orderService.cancelOrder(id));
    }
}
