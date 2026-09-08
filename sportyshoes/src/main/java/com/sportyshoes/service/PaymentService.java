package com.sportyshoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.model.Payment;
import com.sportyshoes.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	public Payment processPayment(double amount) {
		Payment payment = new Payment();
		payment.setAmount(amount);
		return paymentRepository.save(payment);
//		return "Payment saved successfully";
		
	}
}
