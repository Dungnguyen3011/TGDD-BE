package com.project.tgdd_be.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.tgdd_be.entities.Location;
import com.project.tgdd_be.service.LocationService;

@RestController
public class LocationAPI {

	@Autowired
	private LocationService sv;
	

	
	@GetMapping("/api/location")
	public ResponseEntity<?> getAll(){
		List<Location> pr= sv.listAll();
		return ResponseEntity.ok(pr);
	}
	
	@PostMapping("/api/location")
	public ResponseEntity<?> createLocation(Location location) {
		try {
			sv.save(location);
			return ResponseEntity.ok(true);
		}
		catch (Exception e) {
			return ResponseEntity.ok(false);
		}
	}
	
	@GetMapping("/api/location/{id}")
	public ResponseEntity<?> getLocationById(@PathVariable int id){
		return ResponseEntity.ok(sv.getLocationbyID(id));
	}
	
	@DeleteMapping("/api/location/{id}")
	public ResponseEntity<?> deleteLocation(@PathVariable int id){
		try {
			sv.delete(id);
			return ResponseEntity.ok(true);
		}
		catch (Exception e) {
			return ResponseEntity.ok(false);
		}
	}
	
}
