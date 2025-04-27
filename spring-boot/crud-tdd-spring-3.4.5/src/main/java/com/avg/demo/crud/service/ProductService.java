package com.avg.demo.crud.service;

import com.avg.demo.crud.dto.CreateProductDTO;
import com.avg.demo.crud.dto.ProductDTO;
import com.avg.demo.crud.dto.UpdateProductDTO;
import com.avg.demo.crud.model.Product;
import com.avg.demo.crud.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO findById(Long id) {
        Product product =  productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return new ProductDTO(product.getId(),product.getName(),product.getPrice());
    }

    public ProductDTO createProduct(CreateProductDTO createDTO) {
        Product product = productRepository.save(new Product(null, createDTO.name(), createDTO.price()));
        return new ProductDTO(product.getId(),product.getName(),product.getPrice());
    }

    public ProductDTO updateProduct(Long id, UpdateProductDTO updateDTO) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        existing.setName(updateDTO.name());
        existing.setPrice(updateDTO.price());
        productRepository.save(existing);
        return new ProductDTO(existing.getId(),existing.getName(),existing.getPrice());
    }

    public void deleteProduct(Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.deleteById(id);
    }
}
