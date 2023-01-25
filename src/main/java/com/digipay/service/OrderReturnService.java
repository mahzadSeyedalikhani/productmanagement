package com.digipay.service;

import com.digipay.model.entity.OrderReturn;

public interface OrderReturnService {
    OrderReturn returnOrder(String orderId);
}
