package com.digipay.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "PAYMENT")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "payment_id")
    private String paymentId;

    @OneToOne(fetch = FetchType.EAGER)
    private Order order;

    BigDecimal payableAmount;

    BigDecimal payablePenalty;

    private Date paymentDate;

    private Date penaltyPaymentDate;

    public Payment() {
    }

    public Payment(Order order, BigDecimal payableAmount, Date paymentDate, String paymentId){
        this.order = order;
        this.payableAmount = payableAmount;
        this.paymentDate = paymentDate;
        this.paymentId = paymentId;
    }

    public Payment(Order order, BigDecimal payablePenalty, Date penaltyPaymentDate){
        this.order = order;
        this.payablePenalty = payablePenalty;
        this.penaltyPaymentDate = penaltyPaymentDate;

    }
}
