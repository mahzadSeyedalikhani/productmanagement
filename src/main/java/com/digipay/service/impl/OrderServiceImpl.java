package com.digipay.service.impl;

import com.digipay.model.entity.Customer;
import com.digipay.model.entity.Order;
import com.digipay.model.entity.OrderItem;
import com.digipay.model.entity.Product;
import com.digipay.repository.CustomerRepository;
import com.digipay.repository.OrderItemRepository;
import com.digipay.repository.OrderRepository;
import com.digipay.repository.ProductRepository;
import com.digipay.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository,
                            ProductRepository productRepository, OrderItemRepository orderItemRepository){
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }
    @Transactional
    @Override
    public Order registerOrder(List<OrderItem> orderItems, String customerNationalCode){
        Customer customer = customerRepository.findByNationalCode(customerNationalCode);
        List<BigDecimal> productPriceList = new ArrayList<>();
        for(OrderItem orderItem : orderItems){
            Product product = productRepository.findByProductName(orderItem.getProduct().getProductName());
            BigDecimal productPrice = product.getProductPrice();
            productPriceList.add(productPrice);
            orderItem.setProduct(product);
        }
        BigDecimal totalOrderAmount = productPriceList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        return orderRepository.save(new Order(orderItems, customer, totalOrderAmount, UUID.randomUUID().toString(), new Date()));
    }
}
