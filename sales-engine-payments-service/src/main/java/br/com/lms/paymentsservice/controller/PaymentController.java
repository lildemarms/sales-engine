package br.com.lms.paymentsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lms.paymentsservice.dto.PaymentDataDTO;
import br.com.lms.paymentsservice.model.Payment;
import br.com.lms.paymentsservice.model.PaymentStatus;
import br.com.lms.paymentsservice.service.CreditCardService;
import br.com.lms.paymentsservice.service.PaymentService;

@RestController
@RequestMapping(value = "/api/payments", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private CreditCardService creditCardService;

	@GetMapping
	public ResponseEntity<Iterable<Payment>> listAll() {
		return ResponseEntity.ok().body(paymentService.findAll());
	}

	@PostMapping
	public ResponseEntity<Payment> addPendingPayment(@RequestBody @Validated PaymentDataDTO dto) {
		Payment payment = new Payment();
		payment.setStatus(PaymentStatus.PENDING);
		payment.setCreditCard(
				creditCardService.findByNumberIgnoreCaseAndExpiration(dto.getNumber(), dto.getExpiration()));
		payment.setValue(dto.getPaidValue());
		return ResponseEntity.ok().body(paymentService.save(payment));
	}

	@PutMapping
	public ResponseEntity<List<Payment>> pay(@RequestBody @Validated PaymentDataDTO paymentDataDTO) {
		List<Payment> payments = paymentService.pay(paymentDataDTO);
		return ResponseEntity.ok().body(payments);
	}
	
	@GetMapping(value = "/{orderCode}/status")
	public ResponseEntity<String> checkStatus(@PathVariable("orderCode") Integer orderCode) {
		return ResponseEntity.ok().body("XXX");
	}
}
