package com.octavian.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.octavian.core.dao.PaymentDAO;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentDAO payment;
	
	public PaymentDAO getDao() {
		return payment;
	}
	
	public void setDao(PaymentDAO paymentDAO) {
		this.payment = paymentDAO;
	}
}
