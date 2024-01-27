package com.pack.authentication.api.service;

import com.pack.authentication.api.entity.PaymentEntity;

import java.util.List;

public interface PaymentService {

    public PaymentEntity savePayment(PaymentEntity paymentEntity);

    public PaymentEntity postPayment(PaymentEntity paymentEntity);

    public PaymentEntity getPaymentByPaymentId(Integer paymentId);

    public List<PaymentEntity> getAllPayment();

}
