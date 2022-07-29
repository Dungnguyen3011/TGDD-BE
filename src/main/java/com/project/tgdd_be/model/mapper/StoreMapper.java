package com.project.tgdd_be.model.mapper;

import com.project.tgdd_be.entities.Store;
import com.project.tgdd_be.model.dto.StoreDTO;

public class StoreMapper {

	public static StoreDTO toStoreDTO(Store store) {
		StoreDTO sto = new StoreDTO();
		
		sto.setStoreId(store.getStoreId());
		
		sto.setStoreName(store.getStoreName());
		
		sto.setStatus(store.getStatus());
		
		sto.setLocationId(store.getLocation().getLocationId());
		
		return sto;
	}
}
