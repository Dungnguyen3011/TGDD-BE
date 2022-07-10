package com.project.tgdd_be.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tgdd_be.entities.Category;
import com.project.tgdd_be.model.dto.CategoryDTO;
import com.project.tgdd_be.model.mapper.CategoryMapper;
import com.project.tgdd_be.repositories.CategoryRepository;
import com.project.tgdd_be.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService{
	@Autowired
	private CategoryRepository categoryRep;
	
	@Override
	public List<Category> listAll() {
		return categoryRep.findAll();
	}
	
	@Override
	public CategoryDTO findCategoryById(Integer id) {
		CategoryDTO cateDTO = new CategoryDTO();
		Category cate = categoryRep.categoryById(id);
		cateDTO = CategoryMapper.ToCategoryDTO(cate);
		return cateDTO;
	}
	
	@Override
	public Category save(Category cat) {
		return categoryRep.save(cat);
	}
	
	@Override
	public void delete(Integer id) {
		categoryRep.deleteById(id);
	}
	
	@Override
	public CategoryDTO getCategoryDTOByID(Integer id) {
		return CategoryMapper.ToCategoryDTO(categoryRep.findById(id).get());
	}
	
	@Override
	public Category getCategorByID(Integer id) {
		return categoryRep.findById(id).get();	
	}
	
	@Override
	public List<CategoryDTO> listAllForCus(){
		List<CategoryDTO> listdto = new ArrayList<>();		
		List<Category> list = categoryRep.listCateForCus();
		
		for(Category item: list) {	
			listdto.add(CategoryMapper.ToCategoryDTO(item));
		}
		return listdto;
	}
	
	@Override
	public List<CategoryDTO> listAllDTO(){
		List<CategoryDTO> listdto = new ArrayList<>();		
		List<Category> list = categoryRep.findAll();
		
		for(Category item: list) {	
			listdto.add(CategoryMapper.ToCategoryDTO(item));
		}
		return listdto;
	}
	
	
}
