package com.project.tgdd_be.service;

import java.util.List;

import com.project.tgdd_be.entities.Category;
import com.project.tgdd_be.model.dto.CategoryDTO;

public interface CategoryService {

	public List<Category> listAll();
	public List<CategoryDTO> listAllDTO();

	public Category save(Category cat);

	public void delete(Integer id);
	
	public CategoryDTO getCategoryDTOByID(Integer id);

	public Category getCategorByID(Integer id);
	
	public List<CategoryDTO> listAllForCus();
}
