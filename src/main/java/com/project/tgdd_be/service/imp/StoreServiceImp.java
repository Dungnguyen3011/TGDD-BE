package com.project.tgdd_be.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tgdd_be.repositories.StoreRepository;
import com.project.tgdd_be.service.StoreService;
import com.project.tgdd_be.entities.Store;
import com.project.tgdd_be.model.dto.ProductDTO;
import com.project.tgdd_be.model.dto.StoreDTO;
import com.project.tgdd_be.model.mapper.StoreMapper;

@Service
public class StoreServiceImp implements StoreService {
	@Autowired
	private StoreRepository storeRep;

	@Override
	public List<StoreDTO> listAll() {
		List<StoreDTO> listDTO = new ArrayList<>();
		List<Store> list = storeRep.findAll();

		for (Store item : list) {
			listDTO.add(StoreMapper.toStoreDTO(item));
		}
		return listDTO;
	}

	@Override
	public Store save(Store sto) {
		return storeRep.save(sto);
	}

	@Override
	public void delete(Integer id) {
		storeRep.deleteById(id);
	}

	@Override
	public StoreDTO getStorebyID(Integer id) {
		return StoreMapper.toStoreDTO(storeRep.findById(id).get());
	}

	@Override
	public List<StoreDTO> listStoreFindByLocation(Integer id) {
		List<StoreDTO> listDTO = new ArrayList<>();
		List<Store> list = storeRep.listStoreByLocation(id);

		for (Store item : list) {
			listDTO.add(StoreMapper.toStoreDTO(item));
		}
		return listDTO;
	}
}
