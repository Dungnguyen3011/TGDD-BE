package com.project.tgdd_be.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tgdd_be.entities.Product;
import com.project.tgdd_be.repositories.ProductRepository;
import com.project.tgdd_be.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	 private ProductRepository repo;
	
	@Override
	public List<Product> listAll() {
		return repo.findAll();
	}

	@Override
	public void save(Product product) {
		repo.save(product);
	}

	@Override
	public void delete(Integer id) {
		
	}

	@Override
	public Product getProductbyID(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Product> searchProducts(String query) {	
		return repo.searchProductSQL(query);
	}

}
