package com.project.tgdd_be.service;

import java.util.List;

import com.project.tgdd_be.entities.Manufacturer;
import com.project.tgdd_be.model.dto.ManufaturerDTO;

public interface ManufacturerService {
	
	public List<ManufaturerDTO> listAll();
	
	public Manufacturer save(Manufacturer Manufacturer);
	
	public void delete(Integer id);
	
	public ManufaturerDTO getManufacturerbyID(Integer id);
	public List<ManufaturerDTO> listManufacturerForCus();
	public void updateMStatus(Integer[] ids);
}
