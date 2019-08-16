package br.com.lms.paymentsservice.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.lms.paymentsservice.model.CreditCard;
import br.com.lms.paymentsservice.repository.CreditCardRepository;

@Service
public class CreditCardService {

	@Autowired
	private CreditCardRepository creditCardRepository;

	public CreditCard save(@Validated CreditCard creditCard) {
		return creditCardRepository.save(creditCard);
	}

	public Optional<CreditCard> findById(Integer id) {
		return creditCardRepository.findById(id);
	}

	public Iterable<CreditCard> findAll() {
		return creditCardRepository.findAll();
	}

	public CreditCard findByNumberIgnoreCaseAndExpiration(String number, Date expiration) {
		return creditCardRepository.findByNumberIgnoreCaseAndExpiration(number, expiration);
	}

}