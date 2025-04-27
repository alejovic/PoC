package com.avg.demo.crud.dto;

import java.util.List;

public record UpdateOrderDTO(String orderNo, List<Long> productIds) {}
