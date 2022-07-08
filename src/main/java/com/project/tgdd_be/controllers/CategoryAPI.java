package com.project.tgdd_be.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.tgdd_be.entities.Category;
import com.project.tgdd_be.model.dto.CategoryDTO;
import com.project.tgdd_be.service.CategoryService;

@RestController
public class CategoryAPI {
	
	@Autowired
	private CategoryService cs;
	
	public Category dtoToCategory(CategoryDTO cateDTO) {
		Category cate = new Category(cateDTO.getCategoryId(), cateDTO.getCategoryName(),cateDTO.getStatus());
		return cate;
	}
	public Category dtoToStatusCategory(CategoryDTO cateDTO) {
		Category cate = new Category(cateDTO.getCategoryId(),cateDTO.getStatus());
		return cate;
	}
	
	@GetMapping("/api/category")
	public ResponseEntity<?> getAll(){
		List<CategoryDTO> cate= cs.listAllDTO();
		return ResponseEntity.ok(cate);
	}
	
	@GetMapping("/api/categoryForcus")
	public ResponseEntity<?> getAllForCus(){
		List<CategoryDTO> cate= cs.listAllForCus();
		return ResponseEntity.ok(cate);
	}
	
	@PostMapping("/api/category")
	public ResponseEntity<?> createCategory(@RequestBody CategoryDTO cateDTO) {
		Category cate = dtoToCategory(cateDTO);
		return ResponseEntity.ok(cs.save(cate));
	}
	
	@PutMapping("/api/category/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable Integer id, @RequestBody CategoryDTO cateDTO){
		if(cs.getCategorByID(id) != null) {
			Category cate = dtoToCategory(cateDTO);
			return ResponseEntity.ok(cs.save(cate));
		}
		return null;
		
	}
	
	//ket qua sai
	@PutMapping("/api/categoryUpdateStatus/{id}")
	public ResponseEntity<?> updateStatusCategory(@PathVariable Integer id, @RequestBody CategoryDTO cateDTO){
		if(cs.getCategorByID(id) != null) {
			Category cate = dtoToStatusCategory(cateDTO);
			return ResponseEntity.ok(cs.save(cate));
		}
		return null;
		
	}
}
