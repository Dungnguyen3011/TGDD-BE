package com.project.tgdd_be.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.tgdd_be.entities.Product;
import com.project.tgdd_be.model.dto.ProductDTO;
import com.project.tgdd_be.service.ProductService;

@RestController
public class ProductAPI {

	@Autowired
	private ProductService sv;
	
	
	@GetMapping("/api/product")
	public ResponseEntity<?> getAll(){
		List<ProductDTO> pr= sv.listAll();
		return ResponseEntity.ok(pr);
	}
	
	//not working method
	@PostMapping("/api/product")
	public Product createProduct(@RequestBody ProductDTO product) {
		Product pr = new Product();
		BeanUtils.copyProperties(product, pr);
		return sv.save(pr);
	}
	
	@GetMapping("/search/{query}")
	public ResponseEntity<?> searchProducts(@PathVariable String query){
		return ResponseEntity.ok(sv.searchProducts(query));
	}
	
	@GetMapping("/api/productForCus")
	public ResponseEntity<?> getAllForCus(){
		List<ProductDTO> pr= sv.listAllForCus();
		return ResponseEntity.ok(pr);
	}
	
	@GetMapping("/api/productByLocation/{id}")
	public ResponseEntity<?> getProductFindByLocation(@PathVariable Integer id){
		List<ProductDTO> pr= sv.listProductFindByLocation(id);
		return ResponseEntity.ok(pr);
	}
	
//	@PutMapping("/search/{id}")
//	public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody Product product){
//		Product updateProudct = sv.getProductbyID(id);
//		updateProudct.setProductName(product.getProductName());
//		updateProudct.setQuantity(product.getQuantity());
//		updateProudct.setManufacturerId(product.getManufacturerId());
//		updateProudct.setUnitPrice(product.getUnitPrice());
//		updateProudct.setSalePrice(product.getSalePrice());
//		updateProudct.setDescription(product.getDescription());
//		updateProudct.setRate(product.getRate());
//		updateProudct.setCategory(product.getCategory());
//		updateProudct.setStoreId(product.getStoreId());
//		updateProudct.setImage(product.getImage());
//		updateProudct.setStatus(product.getStatus());
//		
//		sv.save(updateProudct);
//		
//		return ResponseEntity.ok(updateProudct);
//	}
}
