package com.digipay.service;

import com.digipay.model.entity.Payment;

public interface PaymentService {

    Payment paymentOrder(String orderId);
}
