package com.octavian.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.octavian.core.service.PaymentService;

@SpringBootTest
class CoreApplicationTests {

	@Autowired
	PaymentService paymentService;
	
	@Test
	void testDependencyInjection() {
		Assert.notNull(paymentService, "Payment service it's not injected!");
	}

}
