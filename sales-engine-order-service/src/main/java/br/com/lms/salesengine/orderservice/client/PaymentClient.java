package br.com.lms.salesengine.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "sales-engine-payments-service")
public interface PaymentClient {

	@GetMapping("/api/payments-status/{orderCode}")
	String checkStatus(@Param("orderCode") String orderCode);
}
