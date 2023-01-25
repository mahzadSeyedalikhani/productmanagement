package com.digipay.service.impl;

import com.digipay.model.entity.Order;
import com.digipay.model.entity.OrderItem;
import com.digipay.model.entity.OrderReturn;
import com.digipay.model.entity.Payment;
import com.digipay.repository.OrderRepository;
import com.digipay.repository.OrderReturnRepository;
import com.digipay.repository.PaymentRepository;
import com.digipay.service.CustomerProfileService;
import com.digipay.service.OrderReturnService;
import com.digipay.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

@Service
public class OrderReturnServiceImpl implements OrderReturnService {

    private final OrderReturnRepository orderReturnRepository;
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final CustomerProfileService customerProfileService;

    private final ProductService productService;


    public OrderReturnServiceImpl(OrderReturnRepository orderReturnRepository,
                                  OrderRepository orderRepository,
                                  PaymentRepository paymentRepository,
                                  CustomerProfileService customerProfileService,
                                  ProductService productService){
        this.orderReturnRepository = orderReturnRepository;
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.customerProfileService = customerProfileService;
        this.productService = productService;
    }
    public OrderReturn returnOrder(String orderId){
        Order order = orderRepository.findByOrderId(orderId);
        Payment orderPayment = paymentRepository.findPaymentByOrder(order);
        Date paymentDate = orderPayment.getPaymentDate();
        GregorianCalendar gregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
        Date returnDate = gregorianCalendar.getTime();
        customerProfileService.calculatePenalty(paymentDate, returnDate, orderId);

        List<OrderItem> orderItems = order.getOrderItems();
        for(OrderItem orderItem: orderItems){
            String productName = orderItem.getProduct().getProductName();
            int productQuantity = orderItem.getQuantity();
            productService.increaseProductInventory(productName, productQuantity);
        }
        return orderReturnRepository.save(new OrderReturn(order, returnDate, UUID.randomUUID().toString()));
    }
}
