package com.avg.demo.crud.service;

import com.avg.demo.crud.model.Product;
import com.avg.demo.crud.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.assertj.core.api.Assertions;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    void testProductById() {
        Product product = new Product(1L, "ProductTestName", 99.99);
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Product foundProduct = productService.findById(1L);
        Assertions.assertThat(foundProduct.getName()).isEqualTo( "ProductTestName");
    }

}
