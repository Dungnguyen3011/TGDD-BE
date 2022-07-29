package com.project.tgdd_be.model.mapper;

import com.project.tgdd_be.entities.Location;
import com.project.tgdd_be.model.dto.LocationDTO;

public class LocationMapper {
	public static LocationDTO toLocationDTO(Location loca) {
		LocationDTO locaDTO = new LocationDTO();
		locaDTO.setLocationId(loca.getLocationId());
		locaDTO.setLocationName(loca.getLocationName());
		return locaDTO;
		
	}
}
