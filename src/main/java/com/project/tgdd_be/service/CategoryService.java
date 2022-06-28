package com.project.tgdd_be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tgdd_be.entities.Category;
import com.project.tgdd_be.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRep;
	
	public List<Category> listAll() {
		return categoryRep.findAll();
	}
	
	public void save(Category cat) {
		categoryRep.save(cat);
	}
	
	
	public void delete(Integer id) {
		categoryRep.deleteById(id);
	}
	
	public Category get(Integer id) {
		return categoryRep.findById(id).get();	
	}
}
