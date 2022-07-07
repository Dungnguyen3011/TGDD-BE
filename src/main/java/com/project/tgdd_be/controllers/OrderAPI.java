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
import com.project.tgdd_be.model.dto.OrderDTO;
import com.project.tgdd_be.service.OrderService;

@RestController
public class OrderAPI {

	@Autowired
	private OrderService os;

	@GetMapping("/api/order")
	public ResponseEntity<?> getAll() {
		List<OrderDTO> lo = os.listAll();
		return ResponseEntity.ok(lo);

	}

	@GetMapping("/api/getOrderBySpecificPhone/{phoneNumber}")
	public ResponseEntity<?> getOrderBySpecificPhone(@PathVariable(name = "phone_number") String phoneNumber) {
		Optional<OrderDTO> opOrder = Optional.of(os.getOrderByPhoneNumber(phoneNumber));
		return opOrder.map(order -> new ResponseEntity<>(order, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/api/listOrderBySpecificPhone/{query}")
	public ResponseEntity<?> getListOrderBySpecificPhone(@PathVariable String query) {
		return ResponseEntity.ok(os.listOrderBySpecificPhone(query));
	}

	@PutMapping("/api/updateShippingStatus/{id}")
	public ResponseEntity<?> updateShippingStatus(@PathVariable Integer id, @RequestBody Order order) {
		Optional<OrderDTO> opOrder = Optional.of(os.getOrderById(id));
		return opOrder.map(order1 -> {
			order.setOrderId(order1.getOrderId());
			return new ResponseEntity<>(os.updateShippingStatus(order), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
