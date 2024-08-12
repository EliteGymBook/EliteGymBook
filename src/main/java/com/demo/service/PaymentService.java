package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.beans.Payment;

public interface PaymentService {

	List<Payment> getAllPayments();
    Optional<Payment> getPaymentById(Long id);
    Payment savePayment(Payment payment);
    void deletePayment(Long id);
}
