package com.project.tgdd_be.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tgdd_be.entities.Order;
import com.project.tgdd_be.repositories.OrderRepository;
import com.project.tgdd_be.service.OrderService;

@Service
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
	public List<Order> listOrderBySpecificPhone(String query) {
		return orderRepository.listOrderBySpecificPhone(query);
	}

	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order updateOrderStatus(Order order) {
		order.setShippingStatus(true);
		return orderRepository.save(order);
	}

}
