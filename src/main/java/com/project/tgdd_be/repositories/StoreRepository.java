package com.project.tgdd_be.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.tgdd_be.entities.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {
	@Query(value = "select s from Store s where  " + "s.location.locationId = :id and s.status = 'TRUE'")
	List<Store> listStoreByLocation(@Param("id") Integer id);
	
	@Query(value = "select s from Store s where s.status = 'true'")
	List<Store> listStoreForCus();

}
