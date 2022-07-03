package com.project.tgdd_be.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.tgdd_be.entities.Order;
import com.project.tgdd_be.entities.Product;
import com.project.tgdd_be.service.OrderService;

@RestController
public class OrderAPI {
	@Autowired
	private OrderService os;

	@GetMapping("/api/order")
	public ResponseEntity<?> getAll() {
		List<Order> lo = os.listAll();
		return ResponseEntity.ok(os);

	}
	@GetMapping("/api/orderBySpecificPhone")
	public ResponseEntity<?> getOrderBySpecificPhone(@RequestParam("phone_number") String phone_number){
		List<Order> lo = os.listOrderBySpecificPhone(phone_number);
		return ResponseEntity.ok(os);
	}
	@PostMapping("/api/product")
	public Order updateOrderStatus(Order order) {
		return os.updateOrderStatus(order);
	}
}
