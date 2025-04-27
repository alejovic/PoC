package com.avg.demo.crud.controller;

import com.avg.demo.crud.dto.CreateProductDTO;
import com.avg.demo.crud.dto.ProductDTO;
import com.avg.demo.crud.dto.UpdateProductDTO;
import com.avg.demo.crud.service.ProductService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping
//    public ResponseEntity<List<ProductDTO>> findAll() {
//        return ResponseEntity.ok(productService.findAll());
//    }

    @GetMapping
    public CollectionModel<EntityModel<ProductDTO>> findAll() {
        List<EntityModel<ProductDTO>> products = productService.findAll().stream()
                .map(product -> EntityModel.of(product,
                        linkTo(methodOn(ProductController.class).getProduct(product.id())).withSelfRel(),
                        linkTo(methodOn(ProductController.class).findAll()).withRel("products")))
                .toList();

        return CollectionModel.of(products,
                linkTo(methodOn(ProductController.class).findAll()).withSelfRel());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
//        ProductDTO dto = productService.findById(id);
//        return ResponseEntity.ok().body(dto);
//    }

    @GetMapping("/{id}")
    public EntityModel<ProductDTO> getProduct(@PathVariable Long id) {
        ProductDTO product = productService.findById(id);

        return EntityModel.of(product,
                linkTo(methodOn(ProductController.class).getProduct(id)).withSelfRel(),
                linkTo(methodOn(ProductController.class).findAll()).withRel("products"));
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
