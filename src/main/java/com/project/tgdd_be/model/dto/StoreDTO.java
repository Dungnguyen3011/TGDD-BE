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
public class StoreDTO {
	private Integer storeId;
	
	@NotEmpty(message = "Store name can not be empty")
	@Size(min = 2, message = "Store name must be at least 2 characters")
	private String storeName;
	
	private boolean status;
	
	@NotNull
	private Integer locationId;

}
