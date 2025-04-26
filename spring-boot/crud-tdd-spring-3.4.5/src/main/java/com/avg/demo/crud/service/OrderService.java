package com.avg.demo.crud.service;

import com.avg.demo.crud.model.Order;
import com.avg.demo.crud.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
