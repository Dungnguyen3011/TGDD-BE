package com.project.tgdd_be.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="tbl_account")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id", nullable = false, updatable = false)
	private String productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="mannufacturer")
	private String manufacturer;
	
	@Column(name="unitPrice")
	private float unitPrice;
	
	@Column(name="description")
	private String description;
	
	@Column(name="rate")
	private int rate;
	
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="image")
	private String image;
}
