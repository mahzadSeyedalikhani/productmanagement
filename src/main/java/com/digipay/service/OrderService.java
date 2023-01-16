package com.digipay.service;

import com.digipay.model.entity.Order;
import com.digipay.model.entity.OrderItem;
import java.util.List;

public interface OrderService {
    Order registerOrder(List<OrderItem> products, String customerNationalCode);
}
