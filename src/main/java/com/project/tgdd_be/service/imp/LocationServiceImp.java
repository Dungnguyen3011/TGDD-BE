package com.project.tgdd_be.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tgdd_be.entities.Location;
import com.project.tgdd_be.model.dto.LocationDTO;
import com.project.tgdd_be.model.mapper.LocationMapper;
import com.project.tgdd_be.repositories.LocationRepository;
import com.project.tgdd_be.service.LocationService;

@Service
public class LocationServiceImp implements LocationService {
	
	@Autowired
	private LocationRepository locRepo;
	
	@Override
	public List<LocationDTO> listAll() {
		List<LocationDTO> listdto = new ArrayList<>();		
		List<Location> list = locRepo.findAll();
		
		for(Location item: list) {	
			listdto.add(LocationMapper.toLocationDTO(item));
		}
		return listdto;
	}

	@Override
	public void save(Location location) {
		locRepo.save(location);
	}

	@Override
	public void delete(Integer id) {
		locRepo.deleteById(id);
	}

	@Override
	public Location getLocationbyID(Integer id) {
		return locRepo.findById(id).get();
	}
	
	@Override
	public LocationDTO getLocationDTObyId(Integer id) {
		return LocationMapper.toLocationDTO(locRepo.findById(id).get());
	}
}
