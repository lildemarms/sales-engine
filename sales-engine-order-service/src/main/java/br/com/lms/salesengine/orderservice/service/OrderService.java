package br.com.lms.salesengine.orderservice.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.lms.salesengine.orderservice.model.Order;
import br.com.lms.salesengine.orderservice.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public Order save(@Validated Order order) {
		order.setCode(UUID.randomUUID().toString());
		return orderRepository.save(order);
	}

	public Optional<Order> findById(Integer id) {
		return orderRepository.findById(id);
	}

	public Iterable<Order> findAll() {
		return orderRepository.findAll();
	}

	public void delete(Integer id) {
		orderRepository.deleteById(id);
	}
}
