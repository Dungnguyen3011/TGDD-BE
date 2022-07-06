package com.project.tgdd_be.service.imp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.tgdd_be.entities.Manufacturer;
import com.project.tgdd_be.model.dto.ManufaturerDTO;
import com.project.tgdd_be.model.mapper.ManufacturerMapper;
import com.project.tgdd_be.repositories.ManufacturerRepository;
import com.project.tgdd_be.service.ManufacturerService;

@Service
public class ManufacturerServiceImp implements ManufacturerService {
	@Autowired
	private ManufacturerRepository Mrepo;
	
	@Override
	public List<ManufaturerDTO> listAll() {
		List<ManufaturerDTO> listdto = new ArrayList<>();		
		List<Manufacturer> list = Mrepo.findAll();
		
		for(Manufacturer item: list) {	
			listdto.add(ManufacturerMapper.toManufaturerDTO(item));
		}
		return listdto;
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
	public ManufaturerDTO getManufacturerbyID(Integer id) {
		//return repo.findById(id).get();
		return ManufacturerMapper.toManufaturerDTO(Mrepo.findById(id).get());
	}


	@Override
	public List<ManufaturerDTO> listManufacturerForCus() {
		List<ManufaturerDTO> listdto = new ArrayList<>();		
		List<Manufacturer> list = Mrepo.listManufacturerForCus();
		
		for(Manufacturer item: list) {	
			listdto.add(ManufacturerMapper.toManufaturerDTO(item));
		}
		return listdto;
	}

	@Override
	public void updateMStatus(Integer[] ids) {
		
		
	}

}
