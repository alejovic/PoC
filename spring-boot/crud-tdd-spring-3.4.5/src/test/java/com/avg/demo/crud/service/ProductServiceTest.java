package com.avg.demo.crud.service;

import com.avg.demo.crud.dto.CreateProductDTO;
import com.avg.demo.crud.dto.ProductDTO;
import com.avg.demo.crud.dto.UpdateProductDTO;
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

        ProductDTO foundProduct = productService.findById(1L);
        Assertions.assertThat(foundProduct.name()).isEqualTo("ProductTestName");
    }

    @Test
    void testCreateProduct() {
        CreateProductDTO createDTO = new CreateProductDTO("ProductTestName", 99.99);
        Mockito.when(productRepository.save(Mockito.any(Product.class)))
                .thenReturn(new Product(1L, "ProductTestName", 99.99));

        ProductDTO savedProduct = productService.createProduct(createDTO);
        Assertions.assertThat(savedProduct.name()).isEqualTo("ProductTestName");
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product(1L, "ProductTestName", 99.99);
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        UpdateProductDTO savedProduct = new UpdateProductDTO("newName", 99.99);
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(new Product(1L, "newName", 99.99));
        ProductDTO updatedProduct = productService.updateProduct(1L, savedProduct);
        Assertions.assertThat(updatedProduct.name()).isEqualTo("newName");

    }

    @Test
    void testDeleteProduct() {
        Product product = new Product(1L, "ProductTestName", 99.99);
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        productService.deleteProduct(1L);
        Mockito.verify(productRepository, Mockito.times(1)).deleteById(1L);

    }
}
