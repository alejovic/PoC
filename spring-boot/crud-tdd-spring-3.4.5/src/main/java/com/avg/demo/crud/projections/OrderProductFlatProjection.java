package com.avg.demo.crud.projections;

public interface OrderProductFlatProjection {
    Long getOrderId();
    String getProductName(); // One row per product per order
}
