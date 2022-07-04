package com.project.tgdd_be.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.tgdd_be.entities.Store;
import com.project.tgdd_be.service.StoreService;

@RestController
public class StoreAPI {
	@Autowired
	private StoreService stv;
	
	@GetMapping("/api/store") 
	public ResponseEntity<?> getAll(){
		List<Store> sto = stv.listAll();
		return ResponseEntity.ok(sto);
	}
	
	@PostMapping("/api/store")
	public Store createStore(Store store) {
		return stv.save(store);
	}
	
	@GetMapping("/api/storeByLocation")
	public ResponseEntity<?> getStoreFindByLocation(@RequestParam("id") Integer id){
		List<Store> st = stv.listStoreFindByLocation(id);
		return ResponseEntity.ok(st);
	}
	
	

}
