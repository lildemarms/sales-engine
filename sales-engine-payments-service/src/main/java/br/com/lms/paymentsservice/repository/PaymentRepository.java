package br.com.lms.paymentsservice.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.lms.paymentsservice.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
