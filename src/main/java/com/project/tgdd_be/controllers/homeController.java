package com.project.tgdd_be.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.tgdd_be.entities.Product;
import com.project.tgdd_be.service.ProductService;

@RestController
public class homeController {

	@Autowired
	private ProductService sv;
	
//	@GetMapping("/api/product")
//	public List<Product> getAll(){
//		List<Product> pr= sv.listAll();
//		return pr;
//	}
	
	@GetMapping("/api/product")
	public ResponseEntity<?> getAll(){
		List<Product> pr= sv.listAll();
		return ResponseEntity.ok(pr);
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> searchProducts(@RequestParam("query") String query){
		return ResponseEntity.ok(sv.searchProducts(query));
	}
}
