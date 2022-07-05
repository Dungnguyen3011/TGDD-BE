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

import lombok.Data;

@Table(name="tbl_product")
@Entity
@Data
public class Product  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id", nullable = false, updatable = false)
	private String productId;
	
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
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "manufacturerId")
	private Manufacturer manufacturer;
	
	@ManyToOne
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
	
	
}
