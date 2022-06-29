package com.project.tgdd_be.service;

import java.util.List;

import com.project.tgdd_be.entities.Manufacturer;

public interface ManufacturerService {
	
	public List<Manufacturer> listAll();
	
	public void save(Manufacturer Manufacturer);
	
	public void delete(Integer id);

	public Manufacturer getManufacturerbyID(Integer id);
}
