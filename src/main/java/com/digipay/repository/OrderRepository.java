package com.digipay.repository;

import com.digipay.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long>{
    Order findByOrderId(String orderId);
}
