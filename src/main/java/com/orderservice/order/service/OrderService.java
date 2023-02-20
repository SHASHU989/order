package com.orderservice.order.service;

import com.orderservice.order.entity.Order;
import com.orderservice.order.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repo;

    public Order saveOrder(Order order){
        return repo.save(order);
    }

    public Optional<Order> getOrder(int id){
        return repo.findById(id);
    }
}
