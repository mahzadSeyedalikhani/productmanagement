package com.digipay.controller;

import com.digipay.model.dto.CustomerRequest;
import com.digipay.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRequest customerRequest){
        customerService.registerCustomer(customerRequest.getNationalCode());
    }
}
