package com.digipay.controller;

import com.digipay.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController{

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping("{orderId}")
    public void payOrder(@PathVariable String orderId){
        paymentService.payOrder(orderId);
    }
}
