package br.com.lms.salesengine.orderservice.repository;

import br.com.lms.salesengine.orderservice.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
