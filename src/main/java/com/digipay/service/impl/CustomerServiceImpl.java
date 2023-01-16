package com.digipay.service.impl;

import com.digipay.model.entity.Customer;
import com.digipay.repository.CustomerRepository;
import com.digipay.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer registerCustomer(String nationalCode) {
        return customerRepository.save(new Customer(nationalCode, UUID.randomUUID().toString()));
    }
}
