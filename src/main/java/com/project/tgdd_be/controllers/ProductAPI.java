package com.project.tgdd_be.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.tgdd_be.entities.Category;
import com.project.tgdd_be.entities.Manufacturer;
import com.project.tgdd_be.entities.Product;
import com.project.tgdd_be.entities.Store;
import com.project.tgdd_be.model.dto.ProductDTO;
import com.project.tgdd_be.model.dto.ProductPagingDTO;
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
		Product pro = new Product(productdto.getProductId(), productdto.getProductName(), productdto.getQuantity(),
				productdto.getUnitPrice(), productdto.getSalePrice(), productdto.getDescription(), productdto.getRate(),
				productdto.getStatus(), productdto.getImage(), cate, manu, sto);
		return pro;
	}
	
	@GetMapping("/api/admin/product")
	public ResponseEntity<?> getAll(@RequestParam("page") int page,
									@RequestParam("limit") int limit){
		ProductPagingDTO result = new ProductPagingDTO();
		result.setCurrentPage(page);
		Pageable pageable =  PageRequest.of(page - 1, limit);
		result.setItems(sv.listAll(pageable));
		result.setTotalPage((int)Math.ceil((double)(sv.totalItems()) / limit));

		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/api/admin/product")
	public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDTO product) {
		Product pr = dtotoProduct(product);
		return ResponseEntity.ok(sv.save(pr));
	}
		
	@GetMapping("/api/admin/search/{query}")
	public ResponseEntity<?> searchProducts(@PathVariable String query){
		return ResponseEntity.ok(sv.searchProducts(query));
	}
	
	@GetMapping("/api/search/{query}")
	public ResponseEntity<?> searchProductsforCus(@PathVariable String query){
		return ResponseEntity.ok(sv.searchProductsforCus(query));
	}
	
	@GetMapping("/api/productForCus")
	public ResponseEntity<?> getAllForCus() {
		List<ProductDTO> pr = sv.listAllForCus();
		return ResponseEntity.ok(pr);
	}
	
	@GetMapping("/api/productSale")
	public ResponseEntity<?> getSale() {
		List<ProductDTO> pr = sv.listSale();
		return ResponseEntity.ok(pr);
	}
	
	@GetMapping("/api/productSale99")
	public ResponseEntity<?> getSale99() {
		List<ProductDTO> pr = sv.listSale99();
		return ResponseEntity.ok(pr);
	}
	
	@GetMapping("/api/productByLocation")
	public ResponseEntity<?> getProductFindByLocation(@RequestParam("locationId") int locationId,
														@RequestParam("categoryId") int categoryId){
		List<ProductDTO> pr = new ArrayList<>();
		if(categoryId == -1) {
			pr= sv.listProductFindByLocation(locationId);
		}else {
			pr= sv.filterByLocationAndCategory(locationId, categoryId);
		}
		
		return ResponseEntity.ok(pr);
	}
	
	@PutMapping("/api/admin/product/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Integer id,@Valid @RequestBody ProductDTO product){
			Product pr = dtotoProduct(product);
			pr.setProductId(id);
			return ResponseEntity.ok(sv.save(pr));			
	}	
	
	@GetMapping("/api/product/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Integer id) {
		ProductDTO pr = sv.getProductDtobyID(id);
		return ResponseEntity.ok(pr);
	}

	@GetMapping("/api/productByCategory/{id}")
	public ResponseEntity<?> getProductByCategory(@PathVariable Integer id) {
		List<ProductDTO> pr = sv.listProductByCategory(id);
		return ResponseEntity.ok(pr);
	}

	@GetMapping("/api/productByManufacturer/{id}")
	public ResponseEntity<?> getProductByManufacturer(@PathVariable Integer id) {
		List<ProductDTO> pr = sv.listProductByManufacturer(id);
		return ResponseEntity.ok(pr);
	}
	
	@PutMapping("/api/admin/deleteProduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
			ProductDTO pr = sv.getProductDtobyID(id);
			Product pro = dtotoProduct(pr);
			pro.setStatus(false);
			return ResponseEntity.ok(sv.save(pro));			
	}
	
	@GetMapping("/api/admin")
	public String admin() {
		return "https://react-tgdd.vercel.app/admin";
	}

	@GetMapping("/api/home")
	public String home() {
		return "hello";
	}

}
