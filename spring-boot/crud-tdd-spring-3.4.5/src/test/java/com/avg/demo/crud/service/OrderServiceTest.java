package com.avg.demo.crud.service;

import com.avg.demo.crud.model.Order;
import com.avg.demo.crud.model.Product;
import com.avg.demo.crud.repository.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    OrderService orderService;

    @Test
    void testProductById() {
        Product product = new Product(1L, "ProductTestName", 99.99);
        Order order = new Order(1L, "ABC-123", List.of(product));
        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        Order foundOrder = orderService.findById(1L);
        Assertions.assertThat(foundOrder.getOrderNo()).isEqualTo( "ABC-123");
        Assertions.assertThat(order.getProducts()).hasSize(1);
    }

}
