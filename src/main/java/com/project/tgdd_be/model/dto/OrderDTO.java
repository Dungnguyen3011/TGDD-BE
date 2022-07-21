package com.project.tgdd_be.model.dto;

import java.sql.Date;

import javax.validation.constraints.Email;

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

	@Email
	private String email;

	private String shippingType;

	private Float totalPrice;

	private Boolean shippingStatus;

	
}
