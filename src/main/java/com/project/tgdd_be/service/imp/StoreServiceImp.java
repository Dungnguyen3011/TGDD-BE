package com.project.tgdd_be.service.imp;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tgdd_be.repositories.StoreRepository;
import com.project.tgdd_be.entities.Store;

@Service
public class StoreServiceImp {
	@Autowired
	private StoreRepository storeRep;
	
	public List<Store> listAll(){
		return storeRep.findAll();
	}
	
	public void save(Store sto) {
		storeRep.save(sto);
	}
	
	public void delete(Integer id) {
		storeRep.deleteById(id);
	}
	
	public Store get(Integer id) {
		return storeRep.findById(id).get();
	}
}

