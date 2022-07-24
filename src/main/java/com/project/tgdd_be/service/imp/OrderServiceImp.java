package com.project.tgdd_be.service.imp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tgdd_be.entities.Order;
import com.project.tgdd_be.entities.OrderDetail;
import com.project.tgdd_be.entities.Product;
import com.project.tgdd_be.model.dto.OrderDTO;
import com.project.tgdd_be.model.dto.OrderDetailDTO;
import com.project.tgdd_be.model.mapper.OrderDetailMapper;
import com.project.tgdd_be.model.mapper.OrderMapper;
import com.project.tgdd_be.repositories.OrderDetailRepository;
import com.project.tgdd_be.repositories.OrderRepository;
import com.project.tgdd_be.repositories.ProductRepository;
import com.project.tgdd_be.service.OrderService;

@Service
public class OrderServiceImp implements OrderService {
	
	Date date = new Date(System.currentTimeMillis());
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private OrderDetailRepository orderDetailRepo;

	@Override
	public List<OrderDTO> listAll() {
		List<OrderDTO> listOrderDTO = new ArrayList<>();
		List<Order> listOrder = orderRepository.findAll();
		for (Order order : listOrder) {
			OrderDTO dto = new OrderDTO();
			dto = OrderMapper.toOrderDTO(order);
			
			List<OrderDetailDTO> listDetaildto = new ArrayList<>();
			List<OrderDetail> listDetail = orderDetailRepo.ListDetailByOrderId(order.getOrderId());
			for(OrderDetail orderdetail : listDetail) {
				listDetaildto.add(OrderDetailMapper.toOrderDeatilDTO(orderdetail));
			}
			dto.setOrderdetailList(listDetaildto);
			listOrderDTO.add(dto);
		}
		return listOrderDTO;
	}

	@Override
	public void delete(Integer id) {
		orderRepository.deleteById(id);
	}

	@Override
	public Order getOrderById(Integer id) {
		/* return orderRepository.findById(id).get(); */
		return orderRepository.findById(id).get();
	}

	@Override
	public List<OrderDTO> listOrderBySpecificPhone(String query) {
		List<OrderDTO> listOrderDTO = new ArrayList<>();
		List<Order> listOrder = orderRepository.listOrderBySpecificPhone(query);
		for (Order order : listOrder) {
			listOrderDTO.add(OrderMapper.toOrderDTO(order));
		}
		/* return orderRepository.listOrderBySpecificPhone(query); */
		return listOrderDTO;
	}

	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}


	@Override
	public Order updateShippingStatus(Integer id, Order order) {
		if (orderRepository.findById(id).isPresent()) {
			Order existOrder = orderRepository.findById(id).get();		
			Order updateOrder = orderRepository.save(existOrder);
			return updateOrder;
		} else {
			return null;
		}
	}

	@Override
	public OrderDTO getOrderByPhoneNumber(String phoneNumber) {
		return OrderMapper.toOrderDTO(orderRepository.findByPhoneNumber(phoneNumber));
	}

	@Override
	public OrderDTO getOrderDTOById(Integer id) {
		return OrderMapper.toOrderDTO(orderRepository.findById(id).get());
	}

	@Override
	public List<OrderDTO> listAllForcus() {
		List<OrderDTO> listOrderDTO = new ArrayList<>();
		List<Order> listOrder = orderRepository.listOrderForCus();
		for (Order order : listOrder) {
			listOrderDTO.add(OrderMapper.toOrderDTO(order));
		}
		return listOrderDTO;
		
	}

	@Override
	public Order saveNewORder(OrderDTO orderdto) {
		Order order = new Order(orderdto);
		order.setOrderDate(date);
		orderRepository.save(order);
		
		
		List<OrderDetail> listOrder = new ArrayList<>();
		
		if(orderdto.getOrderdetailList() != null) {
			for(OrderDetailDTO orderdetailDTO : orderdto.getOrderdetailList()) {
				OrderDetail orderDetail = new OrderDetail();
				Product product = new Product();
				product = repo.findById(orderdetailDTO.getProductId()).get();
				orderDetail.setProduct(product);
				orderDetail.setOrder(order);
				orderDetail.setPrice(orderdetailDTO.getUnitPrice());
				orderDetail.setQuantity(orderdetailDTO.getQuantity());
				
				listOrder.add(orderDetail);
			}
			
			orderDetailRepo.saveAll(listOrder);
		}
		
		order.setOrderdetail(listOrder);
		
		return order;
	}

//	@Override
//	public List<OrderDTO> listAll(Pageable pageable) {
//		List<OrderDTO> listOrderDTO = new ArrayList<>();
//		List<Order> listOrder = orderRepository.findAll(pageable).getContent();
//		for (Order order : listOrder) {
//			listOrderDTO.add(OrderMapper.toOrderDTO(order));
//		}
//		return listOrderDTO;		
//	}

//	@Override
//	public int totalItems() {
//		return (int) orderRepository.count();
//	}


}
