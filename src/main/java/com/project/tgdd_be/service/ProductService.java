package com.project.tgdd_be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tgdd_be.entities.Product;
import com.project.tgdd_be.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository rep;
	
	public List<Product> listAll() {
		return rep.findAll();
	}
	
	public void save(Product product) {
		rep.save(product);
	}
	
	
	public void delete(Integer id) {
		rep.deleteById(id);
	}

	public Product get(Integer id) {
		return rep.findById(id).get();	
	}
	
}
