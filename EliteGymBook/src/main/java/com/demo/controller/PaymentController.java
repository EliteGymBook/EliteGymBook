package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Payment;
import com.demo.service.PaymentService;


	@RestController
	@RequestMapping("/api/payments")
	public class PaymentController {

	    @Autowired
	    private PaymentService paymentService;

	    @GetMapping
	    public List<Payment> getAllPayments() {
	        return paymentService.getAllPayments();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
	        return paymentService.getPaymentById(id)
	                .map(payment -> ResponseEntity.ok().body(payment))
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public Payment createPayment(@RequestBody Payment payment) {
	        return paymentService.savePayment(payment);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment paymentDetails) {
	        return paymentService.getPaymentById(id)
	                .map(payment -> {
	                    payment.setAmount(paymentDetails.getAmount());
	                    payment.setPaymentDate(paymentDetails.getPaymentDate());
	                    Payment updatedPayment = paymentService.savePayment(payment);
	                    return ResponseEntity.ok().body(updatedPayment);
	                }).orElse(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Object> deletePayment(@PathVariable Long id) {
	        return paymentService.getPaymentById(id)
	                .map(payment -> {
	                    paymentService.deletePayment(id);
	                    return ResponseEntity.ok().build();
	                }).orElse(ResponseEntity.notFound().build());
	    }
	}

