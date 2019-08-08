package br.com.lms.paymentsservice.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.lms.paymentsservice.model.CreditCard;

public interface CreditCardRepository extends CrudRepository<CreditCard, Integer> {

}