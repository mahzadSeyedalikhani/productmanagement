package com.digipay.service;

import com.digipay.model.entity.Customer;

public interface CustomerService {
    Customer registerCustomer(String nationalCode);
}
