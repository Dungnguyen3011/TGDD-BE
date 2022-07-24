package com.project.tgdd_be.entities;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.tgdd_be.model.dto.OrderDTO;

import lombok.Data;

@Table(name = "tbl_order")
@Entity
@Data
public class Order  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", nullable = false, updatable = false)
	private Integer orderId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "address")
	private String address;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "shipping_type")
	private String shippingType;

	@Column(name = "total_price")
	private Float totalPrice;

	@Column(name = "shipping_status")
	private Boolean shippingStatus;

	@JsonManagedReference
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	private List<OrderDetail> orderdetail;

	public Order() {
	}

	public Order(Integer orderId, String customerName, Date orderDate, String address, String phoneNumber, String email,
			String shippingType, Float totalPrice, Boolean shippingStatus) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.shippingType = shippingType;
		this.totalPrice = totalPrice;
		this.shippingStatus = shippingStatus;

	}public Order(OrderDTO orderdto) {
		this.customerName=orderdto.getCustomerName();
		this.orderDate = orderdto.getOrderDate();
		this.address = orderdto.getAddress();
		this.phoneNumber = orderdto.getPhoneNumber();
		this.email = orderdto.getEmail();
		this.shippingType = orderdto.getShippingType();
		this.totalPrice = orderdto.getTotalPrice();
		this.shippingStatus = orderdto.getShippingStatus();
	}
	
	

}
