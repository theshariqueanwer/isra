package com.pack.authentication.api.controller;


import com.pack.authentication.api.entity.PaymentEntity;
import com.pack.authentication.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/savePayment")
    public ResponseEntity<PaymentEntity> savePayment(@RequestBody PaymentEntity paymentEntity) {
        PaymentEntity payment = paymentService.savePayment(paymentEntity);
        return new ResponseEntity<PaymentEntity>(payment, HttpStatus.OK);
    }

    @PostMapping("/postPayment")
    public PaymentEntity postPayment(@RequestBody PaymentEntity paymentEntity) {
        return paymentService.postPayment(paymentEntity);
    }

    @GetMapping("/getPaymentByPaymentId/{id}")
    public PaymentEntity getPaymentByPaymentId(@PathVariable ("id") Integer paymentId) {
        return paymentService.getPaymentByPaymentId(paymentId);
    }

    @GetMapping("/getAllPayment")
    public List<PaymentEntity> getAllPayment() {
        return paymentService.getAllPayment();
    }


}
