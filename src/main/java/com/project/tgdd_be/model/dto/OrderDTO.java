package com.project.tgdd_be.model.dto;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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

	@NotBlank(message = "Name is mandatory")	
	@Size(min = 2, message = "Name should have at least 2 characters" )
	private String customerName;

	private Date orderDate;

	@NotEmpty(message = "Address is mandatory")
	private String address;

	@NotEmpty(message = "Phone number is mandatory")	
	private String phoneNumber;

	@NotEmpty(message = "Email is mandatory")
	@Email
	private String email;

	private String shippingType;

	private Float totalPrice;

	private Boolean shippingStatus;

	private List<OrderDetailDTO> orderDetailList;
	
}
