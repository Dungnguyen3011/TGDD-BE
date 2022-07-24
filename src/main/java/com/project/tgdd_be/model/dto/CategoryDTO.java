package com.project.tgdd_be.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
	
	private Integer categoryId;
	
	@NotBlank(message = "Category name can not be empty")	
	@Size(min = 2, message = "Name should have at least 2 characters" )
	private String categoryName;
	
	private Boolean status;
}
