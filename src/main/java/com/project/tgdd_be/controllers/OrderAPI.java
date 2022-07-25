package com.project.tgdd_be.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	@GetMapping("/api/order")
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

	public Order dtoToOrder(OrderDTO orderDTO) throws ParseException {		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");		
		String date1 = formatter.format(orderDTO.getOrderDate());
		java.util.Date date2 = formatter.parse(date1);
	    java.sql.Date sqlDate = new java.sql.Date(date2.getTime());
		Order newOrder = new Order(orderDTO.getOrderId(),orderDTO.getCustomerName(),sqlDate,orderDTO.getAddress(),orderDTO.getPhoneNumber(),orderDTO.getEmail(),orderDTO.getShippingType(),orderDTO.getTotalPrice(),orderDTO.getShippingStatus());
		return newOrder;
	}
	
	@PutMapping("/api/updateShippingStatus/{id}")
	public ResponseEntity<?> updateShippingStatus(@PathVariable Integer id) throws ParseException {
		OrderDTO dto = os.getOrderDTOById(id);
		Order order = dtoToOrder(dto); 
		order.setShippingStatus(false);
		return ResponseEntity.ok(os.save(order));
	}
		
	@PostMapping("/api/createOrder")
	public String createOrder(@Valid @RequestBody OrderDTO orderDTO) {
		os.saveNewOrder(orderDTO);
		return "oke";
	}

}
