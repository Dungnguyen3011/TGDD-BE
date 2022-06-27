package com.project.tgdd_be.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.tgdd_be.entities.Manufacturer;
import com.project.tgdd_be.repositories.ManufacturerRepository;

@Service

public class manufacturerSevice {
	@Autowired
	private ManufacturerRepository MRep;
	public List<Manufacturer> listAll() {
		return MRep.findAll();
	}
	
	public void save(Manufacturer manufacturer) {
		MRep.save(manufacturer);
	}
	
	public void delete(Integer id) {
		MRep.deleteById(id);
	}
	
	public Manufacturer get(Integer id) {
		return MRep.findById(id).get();
	}
}
