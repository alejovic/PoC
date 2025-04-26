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

    public Order createOrder(Order order) {
        return repository.save(order);
    }

    public Order updateOrder(Long id, Order order) {
        Order existingOrder = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        existingOrder.setProducts(order.getProducts());
        existingOrder.setOrderNo(order.getOrderNo());
        return repository.save(existingOrder);
    }

    public void deleteOrder(long id) {
        Order existingOrder = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        repository.delete(existingOrder);
    }
}
