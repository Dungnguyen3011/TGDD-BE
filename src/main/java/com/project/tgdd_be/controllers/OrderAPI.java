package com.project.tgdd_be.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping("/api/orderBySpecificPhone")
	public ResponseEntity<?> getOrderBySpecificPhone(@RequestParam(required=false,name="query") String query){
		/* List<Order> lo = os.listOrderBySpecificPhone(query); */
		return ResponseEntity.ok(os.listOrderBySpecificPhone(query));
	}
	@GetMapping("/api/updateOrderStatus")
	public Order updateOrderStatus(ModelMap model,@ModelAttribute("order")Order order) {
		Optional<Order> opOrder = or.findById(order.getOrderId());
		if (opOrder.isPresent()) {
			//update
			order.setStatus(true);
			
		}else {
			//not exist
			return null;
		}
		return os.updateOrderStatus(order);
	}
}
