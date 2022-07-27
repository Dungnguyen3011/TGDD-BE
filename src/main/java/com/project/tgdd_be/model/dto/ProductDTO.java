package com.project.tgdd_be.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private Integer productId;
	
	@Size(min=5, message = "Product name must have at least 5 character")
	@NotEmpty(message = "Product name can not be empty")
	private String productName;
	
	@NotNull(message = "Quantity can not be empty")
	private Integer quantity;
	
	@NotNull(message = "Unit Price can not be empty")
	private Float unitPrice;
	
	@NotNull(message = "Sale Price can not be empty")
	private Float salePrice;
	
	@Size(min=20, message = "Description must have at least 20 character")
	@NotEmpty(message = "Description can not be empty")
	private String description;
	
	@NotNull(message = "Rating can not be empty")
	private Integer rate;
	
	private Boolean status;
	
	@NotEmpty(message = "Image can not be empty")
	private String image;
	
	@NotNull
	private Integer categoryId;
	
	@NotNull
	private Integer manufacturerId;
	
	@NotNull
	private Integer storeId;
}
