package com.project.tgdd_be.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Table(name="tbl_product")
@Entity
@Data
public class Product  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id", nullable = false, updatable = false)
	private Integer productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="unit_price")
	private Float unitPrice;
	
	@Column(name="sale_price")
	private Float salePrice;
	
	@Column(name="description")
	private String description;
	
	@Column(name="rate")
	private Integer rate;
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name="image")
	private String image;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "manufacturerId")
	private Manufacturer manufacturer;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "storeId")
	private Store store;
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tbl_order_details",
            joinColumns = {
                @JoinColumn(name = "product_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "order_id")}
    )
    private Set<Order> boughtOrders;

	public Product(Integer productId, String productName, Integer quantity, Float unitPrice, Float salePrice,
			String description, Integer rate, Boolean status, String image, Category category,
			Manufacturer manufacturer, Store store) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.salePrice = salePrice;
		this.description = description;
		this.rate = rate;
		this.status = status;
		this.image = image;
		this.category = category;
		this.manufacturer = manufacturer;
		this.store = store;
	}

	public Product() {
		super();
	}
	
	
}
