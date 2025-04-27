package com.avg.demo.crud.controller;

import com.avg.demo.crud.dto.CreateOrderDTO;
import com.avg.demo.crud.dto.OrderDTO;
import com.avg.demo.crud.dto.UpdateOrderDTO;
import com.avg.demo.crud.model.Order;
import com.avg.demo.crud.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        OrderDTO dto = orderService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> save(@RequestBody CreateOrderDTO createDTO) {
        OrderDTO dto =  orderService.createOrder(createDTO);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> update(@PathVariable Long id, @RequestBody UpdateOrderDTO updateDTO) {
        OrderDTO dto =  orderService.updateOrder(id, updateDTO);
        return ResponseEntity.ok().body(dto);
    }
}
