package com.project.tgdd_be.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.tgdd_be.entities.Location;
import com.project.tgdd_be.entities.Store;
import com.project.tgdd_be.model.dto.StoreDTO;
import com.project.tgdd_be.service.LocationService;
import com.project.tgdd_be.service.StoreService;

@RestController
public class StoreAPI {
	@Autowired
	private StoreService stv;
	
	@Autowired
	private LocationService Lsv;

	public Store dtoToStore(StoreDTO storeDTO) {
		Location lc = Lsv.getLocationbyID(storeDTO.getLocationId());
		Store sto = new Store(storeDTO.getStoreId(), storeDTO.getStoreName(), storeDTO.isStatus(), lc);
		return sto;
	}
	@GetMapping("/api/store")
	public ResponseEntity<?> getAll() {
		List<StoreDTO> sto = stv.listAll();
		return ResponseEntity.ok(sto);
	}

	@PostMapping("/api/store")
	public ResponseEntity<?> createStore(@Valid @RequestBody StoreDTO store) {
		Store st = dtoToStore(store);
		return ResponseEntity.ok(stv.save(st));
	}

	@GetMapping("/api/storeByLocation/{id}")
	public ResponseEntity<?> getStoreFindByLocation(@PathVariable Integer id) {
		List<StoreDTO> st = stv.listStoreFindByLocation(id);
		return ResponseEntity.ok(st);
	}

	@PutMapping("api/updateStore/{id}")
	public ResponseEntity<?> updateStore(@PathVariable Integer id, @RequestBody @Valid StoreDTO store) {
		Store st = dtoToStore(store);
		st.setStoreId(id);
		return ResponseEntity.ok(stv.save(st));
	}
	
	@PutMapping("/api/deleteStore/{id}")
	public ResponseEntity<?> deleteStore(@PathVariable Integer id) {
		StoreDTO st = stv.getStoreDTObyID(id);
		Store sto = dtoToStore(st);
		sto.setStatus(false);
		return ResponseEntity.ok(stv.save(sto));
	}
	

}
