package com.project.tgdd_be.service;

import java.util.List;

import com.project.tgdd_be.entities.Store;
import com.project.tgdd_be.model.dto.StoreDTO;

public interface StoreService {

	public List<StoreDTO> listAll();

	public Store save(Store sto);

	public void delete(Integer id);

	public StoreDTO getStorebyID(Integer id);

	public List<StoreDTO> listStoreFindByLocation(Integer id);

}
