package com.avg.demo.crud.controller;

import com.avg.demo.crud.dto.CreateProductDTO;
import com.avg.demo.crud.dto.ProductDTO;
import com.avg.demo.crud.dto.UpdateProductDTO;
import com.avg.demo.crud.model.Product;
import com.avg.demo.crud.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;

    ObjectMapper om;

    @BeforeEach
    void setUp() {
        om = new ObjectMapper();
    }

    @Test
    void testGetProductById() throws Exception {
        ProductDTO product = new ProductDTO(1L, "ProductTestName", 99.99);
        Mockito.when(productService.findById(Mockito.anyLong())).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.get("/products/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("ProductTestName"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(99.99));
    }

    @Test
    void testCreateProduct() throws Exception {
        ProductDTO createDTO = new ProductDTO(1L, "ProductTestName", 99.99);
        Mockito.when(productService.createProduct(Mockito.any(CreateProductDTO.class))).thenReturn(createDTO);
        String requestBody = om.writeValueAsString(createDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                        .contentType("application/json")
                        .content(requestBody)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"));
    }

    @Test
    void testUpdateProduct() throws Exception {
        Product product = new Product(1L, "ProductTestName", 99.99);
        ProductDTO updatedProduct = new ProductDTO(1L, "Changed", 99.99);
        Mockito.when(productService.updateProduct(Mockito.anyLong(), Mockito.any(UpdateProductDTO.class))).thenReturn(updatedProduct);

        String requestBody = om.writeValueAsString(product);
        mockMvc.perform(MockMvcRequestBuilders.put("/products/1")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Changed"));
    }

    @Test
    void testDeleteProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/products/1")
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
