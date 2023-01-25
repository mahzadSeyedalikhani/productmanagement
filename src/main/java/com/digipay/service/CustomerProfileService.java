package com.digipay.service;

import com.digipay.model.entity.CustomerProfile;
import java.util.Date;

public interface CustomerProfileService {

    CustomerProfile registerCustomerProfile(String orderId);
    void calculatePenalty(Date paymentDate, Date returnDate, String orderId);

}
