package com.project.tgdd_be.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.tgdd_be.entities.Order;
import com.project.tgdd_be.entities.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {
	@Query(value = "select * from Store s where  "
			+ "s.locationId = :id and s.status = 'TRUE'")
	List<Store> listStoreByLocation(@Param("id") Integer id);
	
	@Query(value = "UPDATE tbl_store s FROM tbl_store s"
			+ "SET s.status = 'FALSE' "
			+ "WHERE s.status" , nativeQuery = true)
	Order updateOrderStatus();
}
