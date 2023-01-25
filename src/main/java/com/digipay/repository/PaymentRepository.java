package com.digipay.repository;

import com.digipay.model.entity.Order;
import com.digipay.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findPaymentByOrder(Order order);
}
