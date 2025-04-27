package com.avg.demo.crud.projections;

import java.util.List;

public record OrderProductView(Long orderId, List<String> productNames) {}
