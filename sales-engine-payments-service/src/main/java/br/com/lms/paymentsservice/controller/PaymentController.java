package br.com.lms.paymentsservice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lms.paymentsservice.dto.PaymentDataDTO;
import br.com.lms.paymentsservice.model.Payment;

@RestController
@RequestMapping(value = "/api/payments", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentController {

	@PostMapping
	public void save(@RequestBody Payment payment){

	}

	@PutMapping("/{id}")
	public void pay(@RequestBody PaymentDataDTO paymentDataDTO){

	}
}
