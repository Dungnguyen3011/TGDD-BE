package com.project.tgdd_be.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Table(name="tbl_categories")
@Entity
@Data
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id", nullable = false, updatable = false)
	private Integer categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="status")
	private Boolean status;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private Set<Product> products;

	public Category(Integer categoryId, String categoryName, Boolean status) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.status = status;
	}
	
	

	public Category() {
		super();
	}

	
	

}
