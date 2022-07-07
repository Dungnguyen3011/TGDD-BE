package com.project.tgdd_be.controllers;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.tgdd_be.entities.Manufacturer;
import com.project.tgdd_be.entities.Product;
import com.project.tgdd_be.model.dto.ManufaturerDTO;
import com.project.tgdd_be.repositories.ManufacturerRepository;
import com.project.tgdd_be.service.ManufacturerService;
@RestController
public class ManufacturerAPI {
	@Autowired
	private ManufacturerService mv;
	//chay duoc roi
	@GetMapping("/api/manufacturer")
	public ResponseEntity<?> getAll(){
		List<ManufaturerDTO> m= mv.listAll();
		return ResponseEntity.ok(m);
	}
	// chua lam code cu
	@PostMapping("/api/manufacturer")
	public Manufacturer createManufacturer(Manufacturer manufacturer) {
		return mv.save(manufacturer);
	}
	
	// chay duoc roi
	@GetMapping("/api/manufacturerForCus")
	public ResponseEntity<?> getAllForCus(){
		List<ManufaturerDTO> m= mv.listManufacturerForCus();
		return ResponseEntity.ok(m);
		
	}
	//ham delete/ update status=false dang bi sai
	@PutMapping("/api/manufacturer")
	public void updateMStatus(@RequestParam("ids[]") Integer[] ids){}
}


