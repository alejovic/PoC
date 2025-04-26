package com.avg.demo.crud.controller;

import com.avg.demo.crud.model.Product;
import com.avg.demo.crud.service.ProductService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    ProductService productService;

    void testGetProductById() throws Exception {
        Product product = new Product(1L, "ProductTestName", 99.99);
        Mockito.when(productService.findById(Mockito.anyLong())).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.get("/products/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("ProductTestName"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(99.99));
    }
}
