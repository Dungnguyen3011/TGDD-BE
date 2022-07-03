package com.project.tgdd_be.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.tgdd_be.entities.Order;
import com.project.tgdd_be.repositories.OrderRepository;
import com.project.tgdd_be.service.OrderService;

public class OrderServiceImp implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Override
	public List<Order> listAll() {
		return orderRepository.findAll();
	}

	

	@Override
	public void delete(Integer id) {
		orderRepository.deleteById(id);
	}

	@Override
	public Order getOrderById(Integer id) {
		return orderRepository.findById(id).get();
	}

	@Override
	public List<Order> listOrderBySpecificPhone(String phone_number) {
		return orderRepository.listOrderBySpecificPhone(phone_number);
	}

	

	@Override
	public Order save(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	@Override
	public Order updateOrderStatus(Order order) {
		return orderRepository.save(order);
	}
	

}
