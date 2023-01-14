package com.digipay.controller;

import com.digipay.mapper.OrderItemDtoMapper;
import com.digipay.mapper.ProductDtoMapper;
import com.digipay.model.dto.OrderItemDto;
import com.digipay.model.dto.OrderItemRequest;
import com.digipay.model.dto.OrderRequest;
import com.digipay.model.dto.ProductDto;
import com.digipay.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    Logger logger = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    @Autowired
    private OrderItemDtoMapper mapper;

    @Autowired
    private ProductDtoMapper productMapper;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void registerOrder(@RequestBody OrderRequest orderRequest) {
        List<OrderItemDto> orderItemsList = new ArrayList<>();
        List<OrderItemRequest> orderItems = orderRequest.getOrderItems();
        OrderItemDto orderItemDto = new OrderItemDto();
        for (OrderItemRequest orderItem : orderItems) {
            String product = orderItem.getProduct();
            ProductDto mappedProduct = productMapper.stringToProductDto(product);
            if(mappedProduct.getProductCount()>=orderItem.getQuantity()){
                orderItemDto.setProduct(mappedProduct);
                orderItemDto.setQuantity(orderItem.getQuantity());
                orderItemsList.add(orderItemDto);
            }
            else
                logger.info("Sorry, the inventory of {} is not enough", mappedProduct);

        }
        orderService.registerOrder(mapper.orderItemDtoToOrderItem(orderItemsList),
                orderRequest.getCustomerNationalCode());
        }
}
