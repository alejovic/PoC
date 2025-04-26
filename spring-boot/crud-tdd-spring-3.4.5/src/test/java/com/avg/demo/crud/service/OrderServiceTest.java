package com.avg.demo.crud.service;

import com.avg.demo.crud.model.Order;
import com.avg.demo.crud.model.Product;
import com.avg.demo.crud.repository.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderService orderService;

    @Test
    void testOrderById() {
        Product product = new Product(1L, "ProductTestName", 99.99);
        Order order = new Order(1L, "ABC-123", List.of(product));
        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        Order foundOrder = orderService.findById(1L);
        Assertions.assertThat(foundOrder.getOrderNo()).isEqualTo("ABC-123");
        Assertions.assertThat(order.getProducts()).hasSize(1);
    }

    @Test
    void testCreateOrder() {
        Product product = new Product(1L, "ProductTestName", 99.99);
        Order order = new Order(1L, "ABC-123", List.of(product));
        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(order);

        Order savedOrder = orderService.createOrder(order);
        Assertions.assertThat(savedOrder.getOrderNo()).isEqualTo("ABC-123");
    }

    @Test
    void testUpdateOrder() {
        Product product1 = new Product(1L, "Product 1", 99.99);
        Order order = new Order(1L, "ABC-123", List.of(product1));
        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        Product product2 = new Product(2L, "Product 2", 99.99);
        Order savedOrder = new Order(1L, "ABC-123", List.of(product1, product2));
        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(savedOrder);

        Order updatedOrder = orderService.updateOrder(1L, order);
        Assertions.assertThat(order.getOrderNo()).isEqualTo("ABC-123");
        Assertions.assertThat(updatedOrder.getProducts()).hasSize(2);
    }

    @Test
    void testDeleteOrder() {
        Product product1 = new Product(1L, "Product 1", 99.99);
        Order order = new Order(1L, "ABC-123", List.of(product1));
        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        orderService.deleteOrder(1L);
        Mockito.verify(orderRepository, Mockito.times(1)).delete(order);
    }

}
