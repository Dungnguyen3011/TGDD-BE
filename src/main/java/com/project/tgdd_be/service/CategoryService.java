package com.project.tgdd_be.service;

import java.util.List;

import com.project.tgdd_be.entities.Category;

public interface CategoryService {

	public List<Category> listAll();

	public Category save(Category cat);

	public void delete(Integer id);

	public Category getCategorByID(Integer id);
	
	public List<Category> listAllForCus();
	
	public List<Category> deleteCategory();
}
