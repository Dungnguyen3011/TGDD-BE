package com.project.tgdd_be.service;

import java.util.List;

import com.project.tgdd_be.entities.Order;
import com.project.tgdd_be.model.dto.OrderDTO;

public interface OrderService {
	
	public List<OrderDTO> listAll();

	public Order save(Order order);

	public void delete(Integer id);

	public Order getOrderById(Integer id);
	
	public OrderDTO getOrderByPhoneNumber(String phoneNumber);
		
	public List<OrderDTO> listOrderBySpecificPhone(String query);
	
	public Order updateShippingStatus(Integer id, Order order);
	
	public OrderDTO getOrderDTOById(Integer id);
		
}
