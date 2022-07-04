package com.project.tgdd_be.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.project.tgdd_be.entities.Manufacturer;


public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
	@Query(value ="SELECT * FROM tbl_manufacturer m WHERE "+
			"m.status = 'TRUE' ", nativeQuery = true)
	List<Manufacturer> listManufacturerForCus();
	@Modifying
	@Query(value ="UPDATE tbl_manufacturer m "+
			"SET m.status = 'FALSE' "+"WHERE m.manufacturer_id IN ?", nativeQuery = true)
	void updateMStatus(Integer[] ids);
}