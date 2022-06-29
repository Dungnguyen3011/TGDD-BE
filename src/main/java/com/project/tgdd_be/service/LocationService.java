package com.project.tgdd_be.service;

import java.util.List;

import com.project.tgdd_be.entities.Location;

public interface LocationService {
	
	public List<Location> listAll();
	
	public void save(Location location);
	
	public void delete(Integer id);

	public Location getLocationbyID(Integer id);
}
