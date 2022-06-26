package com.project.tgdd_be.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.tgdd_be.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
