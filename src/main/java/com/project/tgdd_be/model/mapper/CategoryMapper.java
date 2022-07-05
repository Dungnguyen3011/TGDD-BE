package com.project.tgdd_be.model.mapper;

import com.project.tgdd_be.entities.Category;
import com.project.tgdd_be.model.dto.CategoryDTO;

public class CategoryMapper {
	public static CategoryDTO ToCategoryDTO(Category cate) {
		CategoryDTO cateDTO = new CategoryDTO();
		cateDTO.setCategoryId(cate.getCategoryId());
		cateDTO.setCategoryName(cate.getCategoryName());
		cateDTO.setStatus(cate.getStatus());
		return cateDTO;
		
	}
}
