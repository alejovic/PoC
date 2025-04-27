package com.avg.demo.crud.controller;

import com.avg.demo.crud.dto.CreateProductDTO;
import com.avg.demo.crud.dto.ProductDTO;
import com.avg.demo.crud.dto.UpdateProductDTO;
import com.avg.demo.crud.model.Product;
import com.avg.demo.crud.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
        ProductDTO dto = productService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody CreateProductDTO createDTO) {
        ProductDTO dto = productService.createProduct(createDTO);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody UpdateProductDTO updateDTO) {
        ProductDTO dto = productService.updateProduct(id, updateDTO);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
