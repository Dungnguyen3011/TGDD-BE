package com.project.tgdd_be.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Table(name = "tbl_order")
@Entity
@Data
public class Order implements Serializable {
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

	@ManyToMany(mappedBy = "boughtOrders")
	private Set<Product> products;

}
