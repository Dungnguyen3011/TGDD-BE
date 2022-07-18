package com.project.tgdd_be.service;

import java.util.List;

import com.project.tgdd_be.entities.Manufacturer;
import com.project.tgdd_be.model.dto.ManufacturerDTO;

public interface ManufacturerService {
	
	public List<ManufacturerDTO> listAll();
	
	public Manufacturer save(Manufacturer Manufacturer);
	
	public void delete(Integer id);
	public ManufacturerDTO findManufacturerById(Integer id);
	
	public Manufacturer getManufacturerbyID(Integer id);
	
	public ManufacturerDTO getManufacturerDtobyID(Integer id);
	
	public Manufacturer getManufacturerbyID2(Integer id);
	
	public List<ManufacturerDTO> listManufacturerForCus();
	
	public void updateMStatus(Integer[] ids);
}
