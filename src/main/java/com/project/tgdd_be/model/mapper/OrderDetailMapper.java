package com.project.tgdd_be.model.mapper;

import com.project.tgdd_be.entities.OrderDetail;
import com.project.tgdd_be.model.dto.OrderDetailDTO;

public class OrderDetailMapper {
	public static OrderDetailDTO toOrderDeatilDTO(OrderDetail orderdetail) {
		OrderDetailDTO dto = new OrderDetailDTO();
		dto.setOrderDetailId(orderdetail.getOrderDetailId());
		dto.setOrderId(orderdetail.getOrder().getOrderId());
		dto.setProductId(orderdetail.getProduct().getProductId());
		dto.setUnitPrice(orderdetail.getPrice());
		dto.setQuantity(orderdetail.getQuantity());
		return dto;
	}
}
