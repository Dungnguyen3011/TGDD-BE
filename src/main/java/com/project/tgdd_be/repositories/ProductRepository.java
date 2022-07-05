package com.project.tgdd_be.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.tgdd_be.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("SELECT p FROM Product p WHERE "+
			"p.productName LIKE CONCAT('%',:query, '%') "+
			"OR p.description LIKE CONCAT('%',:query, '%') ") 
	List<Product> searchProduct(String query);
	
	@Query(value ="SELECT * FROM tbl_product p WHERE "+
			"p.product_name LIKE CONCAT('%',:query, '%') "+
			"OR p.description LIKE CONCAT('%',:query, '%') ", nativeQuery = true) 
	List<Product> searchProductSQL(String query);
	
	@Query(value ="SELECT p FROM Product p WHERE "+
			"p.status = 'true' ")
	List<Product> listProductForCus();
	
	@Query(value ="SELECT * FROM tbl_product p INNER JOIN tbl_store s ON "+
			" p.store_id= s.store_id AND s.location_id= :id AND p.status = 'TRUE'", nativeQuery = true)
	List<Product> listProductByLocation(@Param("id") Integer id);
}
