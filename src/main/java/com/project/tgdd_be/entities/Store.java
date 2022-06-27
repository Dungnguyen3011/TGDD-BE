package com.project.tgdd_be.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="tbl_store")
@Entity
@Data
public class Store {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="store_id", nullable = false, updatable = false)
	private Integer storeId;
	
	@Column(name="store_name")
	private String StoreName;
	

}
