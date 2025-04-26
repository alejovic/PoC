package com.avg.demo.crud.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class OrderTest {

    @Test
    void testCreateProduct() {
        Product product = new Product(1L, "ProductTestName", 99.99);
        Order order = new Order(1L, "ABC-123", List.of(product));
        Assertions.assertThat(order.getProducts()).contains(product);
    }
}
