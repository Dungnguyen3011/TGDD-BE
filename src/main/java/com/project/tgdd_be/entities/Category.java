package com.project.tgdd_be.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
}
