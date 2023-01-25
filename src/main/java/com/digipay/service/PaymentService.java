package com.digipay.service;

import com.digipay.model.entity.Payment;
import java.math.BigDecimal;

public interface PaymentService {

    Payment payOrder(String orderId);

    Payment payPenalty(String orderId, BigDecimal payablePenalty);

}
