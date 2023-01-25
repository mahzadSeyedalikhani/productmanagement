package com.digipay.controller;

import com.digipay.service.OrderReturnService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-returns")
public class OrderReturnController {

    private final OrderReturnService orderReturnService;

    public OrderReturnController(OrderReturnService orderReturnService){
        this.orderReturnService = orderReturnService;
    }
    @GetMapping("{orderId}")
    public void returnOrder(@PathVariable String orderId){
        orderReturnService.returnOrder(orderId);
    }
}
