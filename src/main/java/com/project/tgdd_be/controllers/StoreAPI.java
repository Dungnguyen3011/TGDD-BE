package com.project.tgdd_be.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.tgdd_be.entities.Store;
import com.project.tgdd_be.service.StoreService;

@RestController
public class StoreAPI {
	@Autowired
	private StoreService stv;

	@GetMapping("/api/store")
	public ResponseEntity<?> getAll() {
		List<Store> sto = stv.listAll();
		return ResponseEntity.ok(sto);
	}

	@PostMapping("/api/store")
	public Store createStore(Store store) {
		return stv.save(store);
	}

	@GetMapping("/api/storeByLocation/{id}")
	public ResponseEntity<?> getStoreFindByLocation(@PathVariable Integer id) {
		List<Store> st = stv.listStoreFindByLocation(id);
		return ResponseEntity.ok(st);
	}

	@PutMapping("api/updateStore/{id}")
	public ResponseEntity<?> updateStore(@PathVariable(name = "store_id") Integer id, @RequestBody Store store) {
		Store newStore = stv.getStorebyID(id);
		newStore.setStoreName(store.getStoreName());
		//newStore.setLocationId(store.getLocationId());
		stv.save(newStore);
		return ResponseEntity.ok(newStore);
	}
	

}
