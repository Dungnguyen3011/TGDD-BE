package com.project.tgdd_be.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/api/admin/order")
	public ResponseEntity<?> getAll() {
		List<OrderDTO> lo = os.listAll();
		return ResponseEntity.ok(lo);
	}
	
	@GetMapping("/api/focusOrder")
	public ResponseEntity<?> listFocus() {
		List<OrderDTO> lo = os.listAllForcus();
		return ResponseEntity.ok(lo);
	}

	@GetMapping("/api/listOrderBySpecificPhone/{query}")
	public ResponseEntity<?> getListOrderBySpecificPhone(@PathVariable String query) {
		return ResponseEntity.ok(os.listOrderBySpecificPhone(query));
	}

	public Order dtoToOrder(OrderDTO orderDTO) {		
		Order newOrder = new Order(orderDTO.getOrderId(),orderDTO.getCustomerName(),orderDTO.getOrderDate(),orderDTO.getAddress(),orderDTO.getPhoneNumber(),orderDTO.getEmail(),orderDTO.getShippingType(),orderDTO.getTotalPrice(),orderDTO.getShippingStatus());
		return newOrder;
	}
	
	@PutMapping("/api/admin/updateShippingStatus/{id}")
	public ResponseEntity<?> updateShippingStatus(@PathVariable Integer id)  {
		OrderDTO dto = os.getOrderDTOById(id);
		Order order = dtoToOrder(dto); 
		order.setShippingStatus(true);
		return ResponseEntity.ok(os.save(order));
	}
		
	@PostMapping("/api/checkout")
	public ResponseEntity<?> createOrder(@Valid @RequestBody OrderDTO orderDTO) {
		return ResponseEntity.ok(os.saveNewOrder(orderDTO));
	}

}
