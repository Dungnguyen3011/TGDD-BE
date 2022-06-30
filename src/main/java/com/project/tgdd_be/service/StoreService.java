package com.project.tgdd_be.service;

import java.util.List;

import com.project.tgdd_be.entities.Store;

public interface StoreService {

	public List<Store> listAll();

	public void save(Store sto);

	public void delete(Integer id);

	public Store getStorebyID(Integer id);

}
