package com.project.tgdd_be.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tgdd_be.repositories.StoreRepository;
import com.project.tgdd_be.service.StoreService;
import com.project.tgdd_be.entities.Store;

@Service
public class StoreServiceImp implements StoreService {
	@Autowired
	private StoreRepository storeRep;

	@Override
	public List<Store> listAll() {
		return storeRep.findAll();
	}

	@Override
	public Store save(Store sto) {
		return storeRep.save(sto);
	}

	@Override
	public void delete(Integer id) {
		storeRep.deleteById(id);
	}

	@Override
	public Store getStorebyID(Integer id) {
		return storeRep.findById(id).get();
	}

	@Override
	public List<Store> listStoreFindByLocation(Integer id) {
		return storeRep.listStoreByLocation(id);
	}
}
