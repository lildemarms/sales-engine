package br.com.lms.salesengine.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "sales-engine-payments-service", fallback = PaymentFallback.class)
public interface PaymentClient {

	@GetMapping("/api/payments/{orderCode}/status")
	String checkStatus(@PathVariable("orderCode") String orderCode);
}

@Component
class PaymentFallback implements PaymentClient {

	@Override
	public String checkStatus(String orderCode) {
		return "PENDING";
	}

}