package com.project.tgdd_be.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "tbl_order_details")
@Entity
@Data
public class OrderDetail {
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;
	
	@Column(name="unit_price")
	private Float price;
	
	@Column(name="quantity")
	private Integer quantity;
	
}
