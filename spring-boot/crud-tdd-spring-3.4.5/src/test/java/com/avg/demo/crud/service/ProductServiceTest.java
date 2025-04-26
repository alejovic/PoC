package com.avg.demo.crud.service;

import com.avg.demo.crud.model.Product;
import com.avg.demo.crud.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
        Assertions.assertThat(foundProduct.getName()).isEqualTo("ProductTestName");
    }

    @Test
    void testCreateProduct() {
        Product product = new Product(1L, "ProductTestName", 99.99);
        Mockito.when(productRepository.save(product)).thenReturn(product);

        Product savedProduct = productService.createProduct(product);
        Assertions.assertThat(savedProduct.getName()).isEqualTo("ProductTestName");
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product(1L, "ProductTestName", 99.99);
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Product savedProduct = new Product(1L, "newName", 99.99);
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(savedProduct);
        Product updatedProduct = productService.updateProduct(1L, savedProduct);
        Assertions.assertThat(updatedProduct.getName()).isEqualTo("newName");

    }

    @Test
    void testDeleteProduct() {
        Product product = new Product(1L, "ProductTestName", 99.99);
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        productService.deleteProduct(1L);
        Mockito.verify(productRepository, Mockito.times(1)).deleteById(1L);

    }
}
