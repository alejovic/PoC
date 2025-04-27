package com.avg.demo.crud.repository;

import com.avg.demo.crud.model.Order;
import com.avg.demo.crud.projections.OrderProductFlatProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = """
            SELECT o.id as orderId, p.name as productName
            FROM orders o
            JOIN orders_products op ON o.id = op.order_id
            JOIN product p ON p.id = op.products_id
            """, nativeQuery = true)
    List<OrderProductFlatProjection> fetchOrderWithProductNames();
}
