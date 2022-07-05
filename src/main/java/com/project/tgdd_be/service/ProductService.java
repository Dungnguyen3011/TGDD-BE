package com.project.tgdd_be.service;

import java.util.List;

import com.project.tgdd_be.entities.Product;
import com.project.tgdd_be.model.dto.ProductDTO;

public interface ProductService {
	
	public List<Product> listAll();
	
	public List<ProductDTO> listAllDTO();
		
	public Product save(Product product);
	
	public void delete(Integer id);

	public Product getProductbyID(Integer id);
	
	public List<ProductDTO> searchProducts(String query);
	
	public List<ProductDTO> listAllForCus();
	
	public List<Product> listProductFindByLocation(Integer id);
}
	