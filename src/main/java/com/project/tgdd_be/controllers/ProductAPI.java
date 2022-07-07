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

import com.project.tgdd_be.entities.Category;
import com.project.tgdd_be.entities.Manufacturer;
import com.project.tgdd_be.entities.Product;
import com.project.tgdd_be.entities.Store;
import com.project.tgdd_be.model.dto.ProductDTO;
import com.project.tgdd_be.service.CategoryService;
import com.project.tgdd_be.service.ManufacturerService;
import com.project.tgdd_be.service.ProductService;
import com.project.tgdd_be.service.StoreService;

@RestController
public class ProductAPI {

	@Autowired
	private ProductService sv;
	
	@Autowired
	private ManufacturerService Msv;
	
	@Autowired
	private CategoryService Csv;
	
	@Autowired
	private StoreService Ssv;
	
	public Product dtotoProduct(ProductDTO productdto) {
		Manufacturer manu = Msv.getManufacturerbyID2(productdto.getManufacturerId());
		Category cate = Csv.getCategorByID(productdto.getCategoryId());
		Store sto = Ssv.getStorebyID(productdto.getStoreId());
		Product pro = new Product(productdto.getProductId(), productdto.getProductName(), productdto.getQuantity(), productdto.getUnitPrice(), productdto.getSalePrice(), productdto.getDescription(), productdto.getRate(), productdto.getStatus(), productdto.getImage(), cate, manu, sto);
		return pro;
	}
	
	@GetMapping("/api/product")
	public ResponseEntity<?> getAll(){
		List<ProductDTO> pr= sv.listAll();
		return ResponseEntity.ok(pr);
	}
	
	//not working method
	@PostMapping("/api/product")
	public ResponseEntity<?> createProduct(@RequestBody ProductDTO product) {
		Product pr = dtotoProduct(product);
		return ResponseEntity.ok(sv.save(pr));
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
	
	@PutMapping("/search/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody ProductDTO product){
		if(sv.getProductbyID(id) != null) {
			Product pr = dtotoProduct(product);
			return ResponseEntity.ok(sv.save(pr));
		}
		return null;
		
	}
}
