package com.project.tgdd_be.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.tgdd_be.entities.Product;
import com.project.tgdd_be.model.dto.ProductDTO;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("SELECT p FROM Product p WHERE "+
			"p.productName LIKE CONCAT('%',:query, '%') "+
			"OR p.description LIKE CONCAT('%',:query, '%') ") 
	List<Product> searchProduct(String query);
	
	@Query(value ="SELECT p FROM Product p WHERE "+
			"p.status = 'true' ")
	List<Product> listProductForCus();
	
	@Query(value ="SELECT p FROM Product p WHERE p.store.location.locationId = :id")
	List<Product> listProductByLocation(@Param("id") Integer id);
}
