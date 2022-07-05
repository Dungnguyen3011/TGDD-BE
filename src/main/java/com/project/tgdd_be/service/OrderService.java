package com.project.tgdd_be.service;

import java.util.List;

import com.project.tgdd_be.entities.Order;

public interface OrderService {
	
	public List<Order> listAll();

	public Order save(Order order);

	public void delete(Integer id);

	public Order getOrderById(Integer id);
	
	public Order getOrderByPhone(String phone);
	
	public List<Order> listOrderBySpecificPhone(String query);
	
	public Order updateShipping_status(Order order);
}
