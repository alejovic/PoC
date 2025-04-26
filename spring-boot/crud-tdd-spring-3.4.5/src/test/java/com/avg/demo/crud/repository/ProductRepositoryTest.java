package com.avg.demo.crud.repository;

import com.avg.demo.crud.model.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void testSaveProduct(){
        Product product = new Product(null, "ProductTestName", 99.99);
        Product savedProduct = productRepository.save(product);
        Assertions.assertThat(savedProduct.getId()).isNotNull();
    }
}
