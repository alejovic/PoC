package com.avg.demo.crud.dto;

import java.util.List;

public record CreateOrderDTO(String orderNo, List<Long> productIds) {}
