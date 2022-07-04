package com.project.tgdd_be.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.tgdd_be.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	@Query(value ="SELECT * FROM tbl_categories p WHERE "+
			"p.status = 'TRUE' ", nativeQuery = true)
	List<Category> listCateForCus();
	
	@Query(value ="SELECT * FROM tbl_categories p WHERE "+
			"p.status = 'false' ", nativeQuery = true)
	List<Category> deleteCategory();

}