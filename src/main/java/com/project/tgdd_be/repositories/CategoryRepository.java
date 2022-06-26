package com.project.tgdd_be.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.tgdd_be.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

}