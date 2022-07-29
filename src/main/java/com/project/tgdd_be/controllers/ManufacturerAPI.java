package com.project.tgdd_be.controllers;


import java.text.ParseException;

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
import com.project.tgdd_be.entities.Manufacturer;
import com.project.tgdd_be.entities.Product;
import com.project.tgdd_be.model.dto.ManufacturerDTO;
import com.project.tgdd_be.service.ManufacturerService;
import com.project.tgdd_be.service.ProductService;
@RestController
public class ManufacturerAPI {
	@Autowired
	private ManufacturerService mv;
	
	@Autowired
	private ProductService sv;
	
	public Manufacturer dtotoManufacturer(ManufacturerDTO manufacturerDTO) {
		Manufacturer manufacturer = new Manufacturer(manufacturerDTO.getManufacturerId(), manufacturerDTO.getManufacturerName(), manufacturerDTO.getStatus());
		return manufacturer;
	}
	
	@GetMapping("/api/admin/manufacturer")
	public ResponseEntity<?> getAll(){
		List<ManufacturerDTO> m= mv.listAll();
		return ResponseEntity.ok(m);
	}
	
	@PostMapping("/api/admin/manufacturer")
	public Manufacturer createManufacturer(@RequestBody  @Valid ManufacturerDTO manufacturerDTO) {
		Manufacturer mn =  dtotoManufacturer(manufacturerDTO);
		return mv.save(mn);
		
	}
	
	@GetMapping("/api/manufacturerForCus")
	public ResponseEntity<?> getAllForCus(){
		List<ManufacturerDTO> m= mv.listManufacturerForCus();
		return ResponseEntity.ok(m);
		
	}

	@PutMapping("/api/admin/updatemanufacturer/{id}")
	public ResponseEntity<?> updateManufacturer(@PathVariable Integer id, @RequestBody @Valid ManufacturerDTO manufacturer){
		if(mv.getManufacturerbyID(id) != null) {
			Manufacturer pr = dtotoManufacturer(manufacturer);
			if(manufacturer.getStatus()==false) {
				for(Product product : sv.listProductByManufacturer(id)) {
					product.setStatus(false);
					sv.save(product);
				}
			}
			return ResponseEntity.ok(mv.save(pr));
		}
		return null;		
	}
	@PutMapping("/api/admin/deleteManufacturer/{id}")
	public ResponseEntity<?> deleteStatusManufacturer(@PathVariable Integer id) throws ParseException {
		ManufacturerDTO manuDTO = mv.findManufacturerById(id);
		Manufacturer manu = dtotoManufacturer(manuDTO);
		manu.setStatus(false);
		for(Product product : sv.listProductByManufacturer(id)) {
			product.setStatus(false);
			sv.save(product);
		}
		return ResponseEntity.ok(mv.save(manu));
	}
}


