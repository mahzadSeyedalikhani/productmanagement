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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository,
                            ProductRepository productRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }


    @Transactional
    @Override
    public Order registerOrder(List<OrderItem> orderItems, String customerNationalCode) {
        Customer customer = customerRepository.findByNationalCode(customerNationalCode);
        List<BigDecimal> productPriceList = new ArrayList<>();
        List<OrderItem> ultimateOrderItemList = new ArrayList<>();

        for (OrderItem orderItem : orderItems) {
            OrderItem ultimateOrderItem = new OrderItem();
            Product product = productRepository.findByProductName(orderItem.getProduct().getProductName());
            if (product.getProductCount() >= orderItem.getQuantity()) {
                ultimateOrderItem.setProduct(product);
                ultimateOrderItem.setQuantity(orderItem.getQuantity());
                ultimateOrderItemList.add(ultimateOrderItem);
                BigDecimal productPrice = product.getProductPrice();
                productPriceList.add(productPrice.multiply(new BigDecimal(orderItem.getQuantity())));
                int updatedProductCount = product.getProductCount() - ultimateOrderItem.getQuantity();
                product.setProductCount(updatedProductCount);
                productRepository.save(product);
                if(updatedProductCount == 0){
                    product.setActive(false);
                    productRepository.save(product);
                }
            }
            else
                logger.info("Sorry, the inventory of this product {} is less than your required amount", product);

        }
        BigDecimal totalOrderAmount = productPriceList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        return orderRepository.save(new Order(ultimateOrderItemList, customer,
                totalOrderAmount, UUID.randomUUID().toString(), new Date()));
    }
}
