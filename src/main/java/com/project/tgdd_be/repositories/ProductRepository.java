package com.project.tgdd_be.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.tgdd_be.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
