package com.digipay.service.impl;

import com.digipay.model.entity.Order;
import com.digipay.model.entity.Payment;
import com.digipay.repository.OrderRepository;
import com.digipay.repository.PaymentRepository;
import com.digipay.service.PaymentService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository){
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }
    @Override
    public Payment payOrder(String orderId) {
        Order order = orderRepository.findByOrderId(orderId);
        BigDecimal payableAmount = order.getTotalOrderAmount();
        return paymentRepository.save(new Payment(order, payableAmount, new Date(), UUID.randomUUID().toString()));
    }

    @Override
    public Payment payPenalty(String orderId, BigDecimal payablePenalty) {
        Order order = orderRepository.findByOrderId(orderId);
        Payment payment = paymentRepository.findPaymentByOrder(order);
        payment.setPayablePenalty(payablePenalty);
        payment.setPenaltyPaymentDate(new Date());
        return paymentRepository.save(payment);
    }
}
