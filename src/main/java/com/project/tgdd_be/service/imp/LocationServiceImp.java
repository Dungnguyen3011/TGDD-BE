package com.project.tgdd_be.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tgdd_be.entities.Location;
import com.project.tgdd_be.repositories.LocationRepository;
import com.project.tgdd_be.repositories.ManufacturerRepository;
import com.project.tgdd_be.service.LocationService;

@Service
public class LocationServiceImp implements LocationService {
	
	@Autowired
	private LocationRepository locRepo;
	
	@Override
	public List<Location> listAll() {
		return locRepo.findAll();
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

}
