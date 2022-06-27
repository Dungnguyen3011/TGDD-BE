package com.project.tgdd_be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tgdd_be.entities.Order;
import com.project.tgdd_be.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	public List<Order> listAll() {
		return orderRepository.findAll();
	}
	
	public void save(Order order) {
		orderRepository.save(order);
	}
	
	public void delete(Integer id) {
		orderRepository.deleteById(id);
	}
	
	public Order get(Integer id) {
		return orderRepository.findById(id).get();
	}
}
