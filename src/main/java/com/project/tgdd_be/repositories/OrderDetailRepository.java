package com.project.tgdd_be.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.tgdd_be.entities.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

	@Query(value ="SELECT d FROM OrderDetail d WHERE d.order.orderId = :id")
	List<OrderDetail> ListDetailByOrderId(@Param("id") Integer id);
}
