package com.project.tgdd_be.service;

import java.util.List;

import com.project.tgdd_be.entities.Product;

public interface ProductService {
	
	public List<Product> listAll();
		
	public void save(Product product);
	
	public void delete(Integer id);

	public Product getProductbyID(Integer id);
	
	public List<Product> searchProducts(String query);
}
	