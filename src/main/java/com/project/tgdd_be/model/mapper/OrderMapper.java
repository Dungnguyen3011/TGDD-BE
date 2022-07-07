package com.project.tgdd_be.model.mapper;

import com.project.tgdd_be.entities.Order;
import com.project.tgdd_be.model.dto.OrderDTO;

public class OrderMapper {
	public static OrderDTO toOrderDTO(Order order) {
		OrderDTO dto = new OrderDTO();
		dto.setOrderId(order.getOrderId());
		dto.setCustomerName(order.getCustomerName());
		dto.setAddress(order.getAddress());
		dto.setPhoneNumber(order.getPhoneNumber());
		dto.setEmail(order.getEmail());
		dto.setShippingType(order.getShippingType());
		dto.setTotalPrice(order.getTotalPrice());
		dto.setOrderDate(order.getOrderDate());
		dto.setShippingType(order.getShippingType());
		return dto;
	}
}
