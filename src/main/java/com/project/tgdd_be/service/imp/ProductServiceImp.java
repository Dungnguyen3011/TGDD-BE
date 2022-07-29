package com.project.tgdd_be.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.tgdd_be.entities.Product;
import com.project.tgdd_be.model.dto.ProductDTO;
import com.project.tgdd_be.model.mapper.ProductMapper;
import com.project.tgdd_be.repositories.ProductRepository;
import com.project.tgdd_be.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	 private ProductRepository repo;
	
	
	@Override
	public List<ProductDTO> listAll(Pageable pageable) {
		List<ProductDTO> listdto = new ArrayList<>();		
		List<Product> list = repo.findAll(pageable).getContent();
		for(Product item: list) {	
			listdto.add(ProductMapper.toProductDTO(item));
		}
		return listdto;
	}

	@Override
	public Product save(Product product) {
		return repo.save(product);
	}

	@Override
	public void delete(Integer id) {
		
	}

	@Override
	public ProductDTO getProductDtobyID(Integer id) {
		return ProductMapper.toProductDTO(repo.findById(id).get());
	}

	@Override
	public List<ProductDTO> searchProducts(String query) {	
		List<ProductDTO> listdto = new ArrayList<>();		
		List<Product> list = repo.searchProduct(query);
		
		for(Product item: list) {	
			listdto.add(ProductMapper.toProductDTO(item));
		}
		return listdto;
	}

	@Override
	public List<ProductDTO> listAllForCus() {
		List<ProductDTO> listdto = new ArrayList<>();		
		List<Product> list = repo.listProductForCus();
		
		for(Product item: list) {	
			listdto.add(ProductMapper.toProductDTO(item));
		}
		return listdto;
	}

	@Override
	public List<ProductDTO> listProductDTOFindByLocation(Integer id) {
		List<ProductDTO> listdto = new ArrayList<>();		
		List<Product> list = repo.listProductByLocation(id);
		
		for(Product item: list) {	
			listdto.add(ProductMapper.toProductDTO(item));
		}
		return listdto;
	}

	@Override
	public Product getProductbyID(Integer id) {	
		return repo.findById(id).get();
	}

	@Override
	public List<ProductDTO> listProductDTOByCategory(Integer id) {
		List<ProductDTO> listdto = new ArrayList<>();		
		List<Product> list = repo.listProductByCategory(id);
		
		for(Product item: list) {	
			listdto.add(ProductMapper.toProductDTO(item));
		}
		return listdto;
	}

	@Override
	public List<ProductDTO> listProductDTOByManufacturer(Integer id) {
		List<ProductDTO> listdto = new ArrayList<>();		
		List<Product> list = repo.listProductByManufacturer(id);
		
		for(Product item: list) {	
			listdto.add(ProductMapper.toProductDTO(item));
		}
		return listdto;
	}

	@Override
	public int totalItems() {
		return (int) repo.count();
	}

	@Override
	public List<ProductDTO> searchProductsforCus(String query) {
		List<ProductDTO> listdto = new ArrayList<>();		
		List<Product> list = repo.searchProductforCus(query);
		
		for(Product item: list) {	
			listdto.add(ProductMapper.toProductDTO(item));
		}
		return listdto;
	}

	@Override
	public List<ProductDTO> filterByLocationAndCategory(Integer locationDd, Integer CategoryId) {
		List<ProductDTO> listdto = new ArrayList<>();		
		List<Product> list = repo.listProductByLocationAndCategory(locationDd, CategoryId);
		
		for(Product item: list) {	
			listdto.add(ProductMapper.toProductDTO(item));
		}
		return listdto;
	}

	@Override
	public List<ProductDTO> listSale() {
		List<ProductDTO> listdto = new ArrayList<>();		
		List<Product> list = repo.listProductSale();
		
		for(Product item: list) {	
			listdto.add(ProductMapper.toProductDTO(item));
		}
		return listdto;
	}

	@Override
	public List<ProductDTO> listSale99() {
		List<ProductDTO> listdto = new ArrayList<>();		
		List<Product> list = repo.listProductSale99();
		
		for(Product item: list) {	
			listdto.add(ProductMapper.toProductDTO(item));
		}
		return listdto;
	}

	@Override
	public List<Product> listProductByManufacturer(Integer id) {
		return repo.listProductByManufacturer(id);
	}

	@Override
	public List<Product> listProductByCategory(Integer id) {
		return repo.listProductByCategory(id);
	}

	@Override
	public List<Product> listProductByStore(Integer id) {
		return repo.listProductByStore(id);
	}


}
