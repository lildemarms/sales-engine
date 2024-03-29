package br.com.lms.salesengine.orderservice.controller;

import br.com.lms.salesengine.orderservice.dto.OrderDTO;
import br.com.lms.salesengine.orderservice.model.Order;
import br.com.lms.salesengine.orderservice.service.OrderService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping
	public ResponseEntity<Order> save(@RequestBody OrderDTO orderDTO) {
		Order order = new Order();
		order.setId(null);
		order.setProduct(orderDTO.getProduct());
		order.setPrice(orderDTO.getPrice());
		order.setCode(orderDTO.getCode());

		return ResponseEntity.ok(orderService.save(order));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable("id") Integer id) {
		Optional<Order> order = orderService.findById(id);
		if (order.isPresent()) {
			return ResponseEntity.ok(order.get());
		}

		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<Iterable<Order>> findAll() {
		return ResponseEntity.ok().body(orderService.findAll());
	}

	@GetMapping(value = "/{id}/status")
	public ResponseEntity<?> checkStatus(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(orderService.checkStatus(id));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Order> delete(@PathVariable("id") Integer id) {
		orderService.delete(id);
		return ResponseEntity.ok().build();
	}
}
