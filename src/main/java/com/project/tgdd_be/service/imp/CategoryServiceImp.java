package com.project.tgdd_be.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.tgdd_be.entities.Category;
import com.project.tgdd_be.repositories.CategoryRepository;
import com.project.tgdd_be.service.CategoryService;

public class CategoryServiceImp implements CategoryService{
	@Autowired
	private CategoryRepository categoryRep;
	
	@Override
	public List<Category> listAll() {
		return categoryRep.findAll();
	}
	
	@Override
	public Category save(Category cat) {
		return categoryRep.save(cat);
	}
	
	@Override
	public void delete(Integer id) {
		categoryRep.deleteById(id);
	}
	
	@Override
	public Category getCategorByID(Integer id) {
		return categoryRep.findById(id).get();	
	}
	
	@Override
	public List<Category> listAllForCus(){
		return categoryRep.listCateForCus();
	}
	
	@Override
	public List<Category> deleteCategory(){
		return categoryRep.deleteCategory();
	}
}
