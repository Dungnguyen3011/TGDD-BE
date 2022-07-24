package com.project.tgdd_be.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.tgdd_be.entities.Order;
import com.project.tgdd_be.model.dto.OrderDTO;
//import com.project.tgdd_be.model.dto.OrderPagingDTO;
import com.project.tgdd_be.service.OrderService;

@RestController
public class OrderAPI {

	@Autowired
	private OrderService os;

//	@GetMapping("/api/order")
//	public ResponseEntity<?> getAll(@RequestParam("page") int page,
//			@RequestParam("limit") int limit) {
//		OrderPagingDTO result = new OrderPagingDTO();	
//		result.setCurrentPage(page);
//		Pageable pageable =  PageRequest.of(page - 1, limit);
//		result.setItems(os.listAll(pageable));
//		result.setTotalPage(null);
//		result.setTotalPage((int)Math.ceil((double)(os.totalItems()) / limit));
//
//		return ResponseEntity.ok(result);
//	}
	
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

	/*
	 * @GetMapping("/api/getOrderBySpecificPhone/{phoneNumber}") public
	 * ResponseEntity<?> getOrderBySpecificPhone(@PathVariable(name =
	 * "phone_number") String phoneNumber) { Optional<OrderDTO> opOrder =
	 * Optional.of(os.getOrderByPhoneNumber(phoneNumber)); return opOrder.map(order
	 * -> new ResponseEntity<>(order, HttpStatus.OK)) .orElseGet(() -> new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND)); }
	 */
	@GetMapping("/api/listOrderBySpecificPhone/{query}")
	public ResponseEntity<?> getListOrderBySpecificPhone(@PathVariable String query) {
		return ResponseEntity.ok(os.listOrderBySpecificPhone(query));
	}

//not work 
	/*
	 * @PutMapping("/api/updateShippingStatus/{id}") public ResponseEntity<?>
	 * updateShippingStatus(@PathVariable Integer id, @RequestBody Order order) {
	 * 
	 * Optional<Order> opOrder = Optional.of(os.getOrderById(id)); return
	 * opOrder.map(order1 -> { order.setShippingStatus(order1.getShippingStatus());
	 * return new ResponseEntity<>(os.save(order), HttpStatus.OK); }).orElseGet(()
	 * -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); }
	 */
	public Order dtoToOrder(OrderDTO orderDTO) {	
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");		
//		String date1 = formatter.format(orderDTO.getOrderDate());
//		java.util.Date date2 = formatter.parse(date1);		
		LocalDateTime current = LocalDateTime.now();
//		Date date2 = new java.util.Date();
//		formatter.format(current);
	    java.sql.Date sqlDate = java.sql.Date.valueOf(current.toLocalDate());
	    orderDTO.setShippingStatus(true);
		Order newOrder = new Order(orderDTO.getOrderId(),orderDTO.getCustomerName(),sqlDate,orderDTO.getAddress(),orderDTO.getPhoneNumber(),orderDTO.getEmail(),orderDTO.getShippingType(),orderDTO.getTotalPrice(),orderDTO.getShippingStatus());
		return newOrder;
	}
	
	@PutMapping("/api/updateShippingStatus/{id}")
	public ResponseEntity<?> updateShippingStatus(@PathVariable Integer id) {
		OrderDTO dto = os.getOrderDTOById(id);
		Order order = dtoToOrder(dto); 
		order.setShippingStatus(false);
		return ResponseEntity.ok(os.save(order));
	}
		
	@PostMapping("/api/createOrder")
	public ResponseEntity<?> createOrder(@Valid @RequestBody OrderDTO orderDTO) {
		Order newOrder =  dtoToOrder(orderDTO);
		return ResponseEntity.ok(os.save(newOrder));
	}

}
