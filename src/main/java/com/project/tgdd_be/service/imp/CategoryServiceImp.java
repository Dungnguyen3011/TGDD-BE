package com.project.tgdd_be.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tgdd_be.entities.Category;
import com.project.tgdd_be.repositories.CategoryRepository;
import com.project.tgdd_be.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService{
	@Autowired
	private CategoryRepository categoryRep;
	
	@Override
	public List<Category> listAll() {
		return categoryRep.findAll();
	}
	
	@Override
	public void save(Category cat) {
		categoryRep.save(cat);
	}
	
	@Override
	public void delete(Integer id) {
		categoryRep.deleteById(id);
	}
	
	@Override
	public Category getCategorByID(Integer id) {
		return categoryRep.findById(id).get();	
	}
}
