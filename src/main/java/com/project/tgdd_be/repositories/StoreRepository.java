package com.project.tgdd_be.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.tgdd_be.entities.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {
	@Query(value = "SELECT * FROM tbl_store s INNER JOIN tbl_location l ON "
			+ " s.location_id = l.location_id= :id ", nativeQuery = true)
	List<Store> listStoreByLocation(@Param("id") Integer id);
}
