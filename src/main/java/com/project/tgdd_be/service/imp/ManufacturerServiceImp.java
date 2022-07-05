package com.project.tgdd_be.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.tgdd_be.entities.Manufacturer;
import com.project.tgdd_be.repositories.ManufacturerRepository;
import com.project.tgdd_be.service.ManufacturerService;

@Service
public class ManufacturerServiceImp implements ManufacturerService {
	@Autowired
	private ManufacturerRepository Mrepo;
	
	@Override
	public List<Manufacturer> listAll() {
		return Mrepo.findAll();
	}

	@Override
	public Manufacturer save(Manufacturer Manufacturer) {
		return Mrepo.save(Manufacturer);
	}

	@Override
	public void delete(Integer id) {
		Mrepo.deleteById(id);
	}

	@Override
	public Manufacturer getManufacturerbyID(Integer id) {
		return Mrepo.findById(id).get();
	}

	@Override
	public List<Manufacturer> listManufacturerForCus() {
		
		return Mrepo.listManufacturerForCus();
	}

	@Override
	public void updateMStatus(Integer[] ids) {
		
		
	}

}
