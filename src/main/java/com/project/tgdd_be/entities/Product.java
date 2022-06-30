package com.project.tgdd_be.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="tbl_product")
@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id", nullable = false, updatable = false)
	private String productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="manufacturer_id")
	private Integer manufacturerId;
	
	@Column(name="unit_price")
	private Float unitPrice;
	
	@Column(name="sale_price")
	private Float salePrice;
	
	@Column(name="description")
	private String description;
	
	@Column(name="rate")
	private Integer rate;
	
	@Column(name="category_id")
	private Integer categoryId;
	
	@Column(name="store_id")
	private Integer storeId;
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name="image")
	private String image;
}
