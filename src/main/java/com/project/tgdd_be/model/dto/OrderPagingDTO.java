package com.project.tgdd_be.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderPagingDTO {
	private Integer currentPage;
	private Integer totalPage;
	private List<OrderDTO> items = new ArrayList<>();
}
