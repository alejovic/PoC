package com.avg.demo.crud.repository;

import com.avg.demo.crud.model.Order;
import com.avg.demo.crud.model.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Test
    void testSaveOrder() {
        Product product = productRepository.save(new Product(null, "ProductTestName", 99.99));
        Order order = new Order(null, "ABC-123", List.of(product));
        Order savedOrder = orderRepository.save(order);
        Assertions.assertThat(savedOrder.getId()).isNotNull();
        Assertions.assertThat(savedOrder.getProducts()).hasSize(1);

    }
}
