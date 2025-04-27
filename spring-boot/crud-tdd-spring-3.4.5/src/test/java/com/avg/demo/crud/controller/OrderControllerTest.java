package com.avg.demo.crud.controller;

import com.avg.demo.crud.dto.CreateOrderDTO;
import com.avg.demo.crud.dto.OrderDTO;
import com.avg.demo.crud.dto.ProductDTO;
import com.avg.demo.crud.dto.UpdateOrderDTO;
import com.avg.demo.crud.model.Order;
import com.avg.demo.crud.model.Product;
import com.avg.demo.crud.service.OrderService;
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

import java.util.List;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    OrderService orderService;

    ObjectMapper om;

    @BeforeEach
    void setUp() {
        om = new ObjectMapper();
    }

    @Test
    void testGetOrderById() throws Exception {
        ProductDTO product = new ProductDTO(1L, "ProductTestName", 99.99);
        OrderDTO order = new OrderDTO(1L, "ABC-123", List.of(product));

        Mockito.when(orderService.findById(1L)).thenReturn(order);

        mockMvc.perform(MockMvcRequestBuilders.get("/orders/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("ABC-123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.products[0].name").value("ProductTestName"));
    }

    @Test
    void testCreateOrder() throws Exception {
        ProductDTO product = new ProductDTO(1L, "ProductTestName", 99.99);
        OrderDTO order = new OrderDTO(1L, "ABC-123", List.of(product));
        Mockito.when(orderService.createOrder(Mockito.any(CreateOrderDTO.class))).thenReturn(order);

        String requestBody = om.writeValueAsString(order);

        mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("ABC-123"));
    }

    @Test
    void testUpdateOrder() throws Exception {
        ProductDTO product = new ProductDTO(1L, "ProductTestName", 99.99);
        OrderDTO order = new OrderDTO(1L, "XYZ-333", List.of(product));
        Mockito.when(orderService.updateOrder(Mockito.anyLong(), Mockito.any(UpdateOrderDTO.class))).thenReturn(order);

        String requestBody = om.writeValueAsString(order);
        mockMvc.perform(MockMvcRequestBuilders.put("/orders/1")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("XYZ-333"));
    }
}
