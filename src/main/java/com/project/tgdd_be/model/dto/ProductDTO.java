package com.project.tgdd_be.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private String productId;
	
	private String productName;
	
	private Integer quantity;
	
	private Float unitPrice;
	
	private Float salePrice;
	
	private String description;
	
	private Integer rate;
	
	private Boolean status;
	
	private String image;
	
	private Integer categoryId;
	
	private Integer manufacturerId;
	
	private Integer storeId;
}
