package com.avg.demo.crud.service;

import com.avg.demo.crud.dto.CreateOrderDTO;
import com.avg.demo.crud.dto.OrderDTO;
import com.avg.demo.crud.dto.ProductDTO;
import com.avg.demo.crud.dto.UpdateOrderDTO;
import com.avg.demo.crud.model.Order;
import com.avg.demo.crud.model.Product;
import com.avg.demo.crud.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return buildOrderDTO(order);
    }

    private static OrderDTO buildOrderDTO(Order order) {
        List<ProductDTO> products = order.getProducts().stream()
                .map(product -> new ProductDTO(product.getId(), product.getName(), product.getPrice()))
                .toList();
        return new OrderDTO(order.getId(), order.getOrderNo(), products);
    }

    public OrderDTO createOrder(CreateOrderDTO createDTO) {
        List<Product> products = createDTO.productIds().stream()
                .map(productId -> new Product(productId, null, null))
                .toList();

        Order order = repository.save(new Order(null, createDTO.orderNo(), products));
        return buildOrderDTO(order);
    }

    public OrderDTO updateOrder(Long id, UpdateOrderDTO updateOrderDTO) {
        Order existingOrder = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        List<Product> products = updateOrderDTO.productIds().stream()
                .map(productId -> new Product(productId, null, null))
                .toList();

        existingOrder.setProducts(products);
        existingOrder.setOrderNo(updateOrderDTO.orderNo());
        repository.save(existingOrder);
        return buildOrderDTO(existingOrder);
    }

    public void deleteOrder(long id) {
        Order existingOrder = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        repository.delete(existingOrder);
    }
}
