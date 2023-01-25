package com.digipay.service.impl;

import com.digipay.model.entity.Customer;
import com.digipay.model.entity.CustomerProfile;
import com.digipay.model.entity.Order;
import com.digipay.model.entity.Payment;
import com.digipay.repository.CustomerProfileRepository;
import com.digipay.repository.OrderRepository;
import com.digipay.repository.PaymentRepository;
import com.digipay.service.CustomerProfileService;
import com.digipay.service.PaymentService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final PaymentService paymentService;
    private final OrderRepository orderRepository;
    private final CustomerProfileRepository customerProfileRepository;
    private final PaymentRepository paymentRepository;

    public CustomerProfileServiceImpl(PaymentService paymentService, OrderRepository orderRepository,
                                      CustomerProfileRepository customerProfileRepository,
                                      PaymentRepository paymentRepository){
        this.paymentService = paymentService;
        this.orderRepository = orderRepository;
        this.customerProfileRepository = customerProfileRepository;
        this.paymentRepository = paymentRepository;
    }

    int rentPeriod = 2;
    BigDecimal penaltyAmountPerDay = new BigDecimal(100000);

    public void calculatePenalty(Date paymentDate, Date returnDate, String orderId){
        GregorianCalendar paymentGregorianCalendar = new GregorianCalendar();
        paymentGregorianCalendar.setTime(paymentDate);

        GregorianCalendar expectedReturnDate = paymentGregorianCalendar;
        expectedReturnDate.add(GregorianCalendar.DATE, rentPeriod);

        GregorianCalendar actualReturnDate = new GregorianCalendar();
        actualReturnDate.setTime(returnDate);

        Long delayCount = actualReturnDate.getTimeInMillis() - expectedReturnDate.getTimeInMillis();
        long delayCount_In_Days = TimeUnit.MILLISECONDS.toDays(delayCount) % 365;

        if(delayCount_In_Days>0){
            BigDecimal payablePenalty = penaltyAmountPerDay.multiply(new BigDecimal(delayCount_In_Days));
            paymentService.payPenalty(orderId, payablePenalty);
        }
        registerCustomerProfile(orderId);
    }

    public CustomerProfile registerCustomerProfile(String orderId){
        Order order = orderRepository.findByOrderId(orderId);
        Customer customer = order.getCustomer();
        Payment orderPayment = paymentRepository.findPaymentByOrder(order);
        BigDecimal penalty = orderPayment.getPayablePenalty();
        return customerProfileRepository.save(new CustomerProfile(customer, order, penalty));
    }
}
