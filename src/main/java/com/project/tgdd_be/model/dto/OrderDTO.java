package com.project.tgdd_be.model.dto;

import java.sql.Date;
import java.util.Set;

import com.project.tgdd_be.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	private Integer orderId;

	private String customerName;

	private Date orderDate;

	private String address;

	private String phoneNumber;

	private String email;

	private String shippingType;

	private Float totalPrice;

	private Boolean shippingStatus;

	private Set<Product> products;
}
