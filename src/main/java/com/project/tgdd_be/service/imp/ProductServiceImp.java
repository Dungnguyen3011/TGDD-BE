package com.project.tgdd_be.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tgdd_be.entities.Product;
import com.project.tgdd_be.model.dto.ProductDTO;
import com.project.tgdd_be.model.mapper.ProductMapper;
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
	public Product save(Product product) {
		return repo.save(product);
	}

	@Override
	public void delete(Integer id) {
		
	}

	@Override
	public Product getProductbyID(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public List<ProductDTO> searchProducts(String query) {	
		List<ProductDTO> listdto = new ArrayList<>();		
		List<Product> list = repo.searchProduct(query);
		
		for(Product item: list) {	
			listdto.add(ProductMapper.toProductDTO(item));
		}
		return listdto;
	}

	@Override
	public List<ProductDTO> listAllForCus() {
		List<ProductDTO> listdto = new ArrayList<>();		
		List<Product> list = repo.listProductForCus();
		
		for(Product item: list) {	
			listdto.add(ProductMapper.toProductDTO(item));
		}
		return listdto;
	}

	@Override
	public List<Product> listProductFindByLocation(Integer id) {
		return repo.listProductByLocation(id);
	}

	@Override
	public List<ProductDTO> listAllDTO() {
		List<ProductDTO> listdto = new ArrayList<>();		
		List<Product> list = repo.findAll();
		
		for(Product item: list) {	
			listdto.add(ProductMapper.toProductDTO(item));
		}
		return listdto;
	}

}
