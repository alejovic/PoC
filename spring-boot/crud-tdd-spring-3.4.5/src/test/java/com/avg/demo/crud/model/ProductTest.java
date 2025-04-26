package com.avg.demo.crud.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class ProductTest {

    @Test
    void testCreateProduct(){
        Product product = new Product(1L, "ProductTestName", 99.99);
        Assertions.assertThat(product.getName(), "ProductTestName");
        Assertions.assertThat(producct.getPrice(), 99.99);
    }
}
