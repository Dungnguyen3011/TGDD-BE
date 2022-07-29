package com.project.tgdd_be.model.mapper;

import com.project.tgdd_be.entities.Manufacturer;
import com.project.tgdd_be.model.dto.ManufacturerDTO;

public class ManufacturerMapper {
	public static ManufacturerDTO toManufaturerDTO(Manufacturer manu) {
		ManufacturerDTO manuDTO = new ManufacturerDTO();
		manuDTO.setManufacturerId(manu.getManufacturerId());
		manuDTO.setManufacturerName(manu.getManufacturerName());
		manuDTO.setStatus(manu.getStatus());
		return manuDTO;
		
	}
}
