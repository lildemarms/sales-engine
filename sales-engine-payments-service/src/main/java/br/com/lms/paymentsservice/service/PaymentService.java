package br.com.lms.paymentsservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.lms.paymentsservice.dto.PaymentDataDTO;
import br.com.lms.paymentsservice.model.Payment;
import br.com.lms.paymentsservice.model.PaymentStatus;
import br.com.lms.paymentsservice.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private CreditCardService creditCardService;

	public Payment save(@Validated Payment payment) {
		return paymentRepository.save(payment);
	}

	public Optional<Payment> findById(Integer id) {
		return paymentRepository.findById(id);
	}

	public Iterable<Payment> findAll() {
		return paymentRepository.findAll();
	}

	public void delete(Integer id) {
		paymentRepository.deleteById(id);
	}

	@Transactional
	public List<Payment> pay(PaymentDataDTO dtoPay) {
		// Lista com os pagamentos q foram finalizados nesta operacao
		List<Payment> payments = new ArrayList<>();

		// Guarda valor pago para ser decrementado
		Double saldoPagamento = dtoPay.getPaidValue();

		if (saldoPagamento > 0) {
			// Busca pagamentos pendentes e lança valor pago neles. Caso não existe ou seja
			// excedente insere novo Payment
			List<Payment> pendingPayments = paymentRepository.findByPendingPaymentsFromCard(dtoPay.getNumber(),
					dtoPay.getExpiration());

			for (Payment pendingPayment : pendingPayments) {
				if (saldoPagamento <= 0) {
					break;
				}

				if (pendingPayment.getValue().doubleValue() <= saldoPagamento) {
					pendingPayment.setStatus(PaymentStatus.PAID);

					// Decreementa valor do Payment do saldo pago
					saldoPagamento -= pendingPayment.getValue().doubleValue();
				} else {
					pendingPayment.setValue(pendingPayment.getValue().doubleValue() - saldoPagamento);
					saldoPagamento = 0.0;
				}

				// grava Payment para status PAID e insere na lista de retorno
				payments.add(paymentRepository.save(pendingPayment));
			}

			if (saldoPagamento > Double.valueOf(0)) {
				Payment newPayment = new Payment();
				newPayment.setStatus(PaymentStatus.PAID);
				newPayment.setCreditCard(creditCardService.findByNumberIgnoreCaseAndExpiration(dtoPay.getNumber(),
						dtoPay.getExpiration()));
				newPayment.setValue(saldoPagamento);
				payments.add(paymentRepository.save(newPayment));
			}
		}

		return payments.isEmpty() ? null : payments;
	}

}
