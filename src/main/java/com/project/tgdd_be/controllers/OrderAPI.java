package com.project.tgdd_be.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.tgdd_be.entities.Order;
import com.project.tgdd_be.repositories.OrderRepository;
import com.project.tgdd_be.service.OrderService;

@RestController
public class OrderAPI {
	@Autowired
	private OrderService os;
	@Autowired
	private OrderRepository or;

	@GetMapping("/api/order")
	public ResponseEntity<?> getAll() {
		List<Order> lo = os.listAll();
		return ResponseEntity.ok(lo);

	}
	@GetMapping("/api/orderBySpecificPhone/{phone}")
	public ResponseEntity<?> getOrderBySpecificPhone(@PathVariable(name="phone_number") String phone){
		Optional<Order> opOrder = Optional.of(or.findByPhone(phone));
		return opOrder.map(order -> new ResponseEntity<>(order,HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@PutMapping("/api/updateOrderStatus/{id}")
	public ResponseEntity<?> updateOrderStatus(@PathVariable(name="order_id")Integer id, @RequestBody Order order) {
		Optional<Order> opOrder = or.findById(id);
		
		return opOrder.map(order1 -> {
			order.setOrderId(order1.getOrderId());
			return new ResponseEntity<>(or.updateOrderStatus(),HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
}
