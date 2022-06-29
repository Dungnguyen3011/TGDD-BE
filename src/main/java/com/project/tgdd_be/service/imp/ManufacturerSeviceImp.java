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
	 private ManufacturerRepository Mre;
	
	@Override
	public List<Manufacturer> listAll() {
		return Mre.findAll();
	}

	@Override
	public void save (Manufacturer Manufacturer) {
		Mre.save(Manufacturer);
	}

	@Override
	public void delete(Integer id) {
		Mre.deleteById(id);
	}

	@Override
	public Manufacturer getManufacturerbyID(Integer id) {
		return Mre.findById(id).get();
	}

}
