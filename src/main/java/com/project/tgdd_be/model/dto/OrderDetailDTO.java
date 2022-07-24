package com.project.tgdd_be.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
	private Integer orderDetailId;
	private Integer productId;
	private Integer orderId;
	private Float unitPrice;
	private Integer quantity;
}
