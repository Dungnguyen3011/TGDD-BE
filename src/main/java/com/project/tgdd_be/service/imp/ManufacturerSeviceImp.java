package com.project.tgdd_be.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.tgdd_be.entities.Manufacturer;
import com.project.tgdd_be.repositories.ManufacturerRepository;
import com.project.tgdd_be.service.ManufacturerSevice;

@Service

public class ManufacturerSeviceImp implements ManufacturerSevice {
	@Autowired
	 private ManufacturerRepository Mrepo;
	
	@Override
	public List<Manufacturer> listAll() {
		return Mrepo.findAll();
	}

	@Override
	public void save (Manufacturer Manufacturer) {
		Mrepo.save(Manufacturer);
	}

	@Override
	public void delete(Integer id) {
		Mrepo.deleteById(id);
	}

	@Override
	public Manufacturer getManufacturerbyID(Integer id) {
		return Mrepo.findById(id).get();
	}

}
