package com.project.tgdd_be.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.tgdd_be.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	@Query(value ="SELECT c FROM Category c WHERE "+
			"c.status = 'TRUE' ")
	List<Category> listCateForCus();
	
	@Query(value ="SELECT c FROM Category c WHERE c.categoryId = :id")
	Category categoryById(@Param("id") Integer id);

}