package com.orderservice.order.controller;

import com.orderservice.order.entity.Order;
import com.orderservice.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;
    @PostMapping("/orders")
    public Order bookOrder(@RequestBody Order order){
        return service.saveOrder(order);
    }

    @GetMapping("/orderid/{id}")
    public Optional<Order> getOrderDetails(@PathVariable int id){
        return service.getOrder(id);
    }

}
