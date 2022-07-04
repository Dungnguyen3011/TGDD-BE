package com.project.tgdd_be.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.tgdd_be.entities.Category;
import com.project.tgdd_be.service.CategoryService;

@RestController
public class CategoryAPI {
	
	@Autowired
	private CategoryService cs;
	
	@GetMapping("/api/category")
	public ResponseEntity<?> getAll(){
		List<Category> cate= cs.listAll();
		return ResponseEntity.ok(cate);
	}
	
	@GetMapping("/api/categoryForcus")
	public ResponseEntity<?> getAllForCus(){
		List<Category> cate= cs.listAllForCus();
		return ResponseEntity.ok(cate);
	}
	
	@PostMapping("/api/category")
	public Category createCategory(Category cate) {
		return cs.save(cate);
	}
	
	@PutMapping("/api/category")
	public Category updateCategory(Category cate) {
		return cs.save(cate);
	}
	
	@GetMapping("/api/categoryDelete")
	public ResponseEntity<?> deleteCategory(){
		List<Category> cate= cs.deleteCategory();
		return ResponseEntity.ok(cate);
		
	}
}
