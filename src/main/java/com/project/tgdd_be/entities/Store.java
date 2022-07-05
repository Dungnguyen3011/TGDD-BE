package com.project.tgdd_be.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "tbl_store")
@Entity
@Data
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id", nullable = false, updatable = false)
	private Integer storeId;


	@Column(name = "store_name")
	private String storeName;

	@Column(name = "status")
	private Boolean status;
	
	@OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
	private Set<Product> products;
	
	@ManyToOne
	@JoinColumn(name = "locationId")
	private Location location;
}
