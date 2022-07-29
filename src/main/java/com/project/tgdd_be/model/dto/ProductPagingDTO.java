package com.project.tgdd_be.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductPagingDTO {
	private Integer currentPage;
	private Integer totalPage;
	private List<ProductDTO> items = new ArrayList<>();
}
