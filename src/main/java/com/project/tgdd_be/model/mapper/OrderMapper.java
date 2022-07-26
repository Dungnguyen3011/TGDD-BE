package com.project.tgdd_be.model.mapper;

import java.util.ArrayList;
import java.util.List;

import com.project.tgdd_be.entities.Order;
import com.project.tgdd_be.entities.OrderDetail;
import com.project.tgdd_be.model.dto.OrderDTO;
import com.project.tgdd_be.model.dto.OrderDetailDTO;

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
		dto.setShippingStatus(order.getShippingStatus());
		OrderDetailDTO detaildto = new OrderDetailDTO();
		List<OrderDetailDTO> detaildtoList = new ArrayList<>();
		for(OrderDetail detail: order.getOrderDetailList()) {
			detaildto= OrderDetailMapper.toOrderDeatilDTO(detail);
			detaildtoList.add(detaildto);
		}
		dto.setOrderDetailList(detaildtoList);
		return dto;
	}
}
