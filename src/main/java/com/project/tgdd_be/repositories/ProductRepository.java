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
	
	@Query("SELECT p FROM Product p WHERE p.status = 'true' "+
			" AND p.productName LIKE CONCAT('%',:query, '%') "+
			" OR p.description LIKE CONCAT('%',:query, '%') ")
	List<Product> searchProductforCus(String query);
	
	@Query(value ="SELECT p FROM Product p WHERE "+
			"p.status = 'true'")
	List<Product> listProductForCus();
	
	@Query(value ="SELECT p FROM Product p WHERE "+
			"p.status = 'true' AND p.salePrice != 0")
	List<Product> listProductSale();
	
	@Query(value ="SELECT p FROM Product p WHERE "+
			"p.status = 'true' AND p.salePrice = 99 ")
	List<Product> listProductSale99();
	
	@Query(value ="SELECT p FROM Product p WHERE p.store.location.locationId = :id")
	List<Product> listProductByLocation(@Param("id") Integer id);
	
	@Query(value ="SELECT p FROM Product p WHERE p.category.categoryId = :id")
	List<Product> listProductByCategory(@Param("id") Integer id);
	
	@Query(value ="SELECT p FROM Product p WHERE p.manufacturer.manufacturerId = :id")
	List<Product> listProductByManufacturer(@Param("id") Integer id);
	
	@Query(value ="SELECT p FROM Product p WHERE p.store.location.locationId = :Lid AND p.category.categoryId = :Cid")
	List<Product> listProductByLocationAndCategory(@Param("Lid") Integer LId, @Param("Cid") Integer CId);
	
	@Query(value ="SELECT p FROM Product p WHERE p.store.storeId = :id")
	List<Product> listProductByStore(@Param("id") Integer id);
}
