package br.com.lms.paymentsservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.lms.paymentsservice.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

	@Query("SELECT p FROM Payment p WHERE LOWER(p.creditCard.number) = LOWER(:number) and"
			+ " p.creditCard.expiration = :expiration and p.status like 'PENDING'")
	List<Payment> findByPendingPaymentsFromCard(@Param("number") String number, @Param("expiration") Date expiration); 
}
