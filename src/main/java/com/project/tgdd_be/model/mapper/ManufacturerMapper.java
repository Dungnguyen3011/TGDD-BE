package com.project.tgdd_be.model.mapper;

import com.project.tgdd_be.entities.Manufacturer;
import com.project.tgdd_be.model.dto.ManufaturerDTO;

public class ManufacturerMapper {
	public static ManufaturerDTO toManufaturerDTO(Manufacturer manu) {
		ManufaturerDTO manuDTO = new ManufaturerDTO();
		manuDTO.setManufacturerId(manu.getManufacturerId());
		manuDTO.setManufacturerName(manu.getManufacturerName());
		manuDTO.setStatus(manu.getStatus());
		return manuDTO;
		
	}
}
