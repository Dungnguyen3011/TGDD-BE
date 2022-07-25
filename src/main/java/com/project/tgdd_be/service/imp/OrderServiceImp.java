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
import com.project.tgdd_be.service.EmailSenderService;
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
	
	@Autowired
	private EmailSenderService emailsv;

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
			dto.setOrderDetailList(listDetaildto);
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
		return orderRepository.findById(id).get();
	}

	@Override
	public List<OrderDTO> listOrderBySpecificPhone(String query) {
		List<OrderDTO> listOrderDTO = new ArrayList<>();
		List<Order> listOrder = orderRepository.listOrderBySpecificPhone(query);
		for (Order order : listOrder) {
			listOrderDTO.add(OrderMapper.toOrderDTO(order));
		}
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
	public Order saveNewOrder(OrderDTO orderdto) {
		Order order = new Order(orderdto);

		order.setShippingStatus(true);
		orderRepository.save(order);
		
		
		List<OrderDetail> listOrderDetail = new ArrayList<>();
		
		if(orderdto.getOrderDetailList() != null) {
			for(OrderDetailDTO orderdetailDTO : orderdto.getOrderDetailList()) {
				OrderDetail orderDetail = new OrderDetail();
				Product product = new Product();
				product = repo.findById(orderdetailDTO.getProductId()).get();
				orderDetail.setProduct(product);
				orderDetail.setOrder(order);
				orderDetail.setPrice(orderdetailDTO.getUnitPrice());
				orderDetail.setQuantity(orderdetailDTO.getQuantity());
				
				listOrderDetail.add(orderDetail);
			}
			
			orderDetailRepo.saveAll(listOrderDetail);
		}
		
		order.setOrderDetail(listOrderDetail);
		emailsv.send(orderdto.getEmail(), buildEmail(orderdto.getCustomerName(),"" ));
		
		return order;
	}
	
	private String buildEmail(String name, String link) {
        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Confirm your order</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + name + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Thank you for buying at TGDD. Please click on the below link to confirm your order: </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> <a href=\"" + link + "\">CONFIRM</a> </p></blockquote>\n The link will expire in 15 minutes. <p>Thank you</p>" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";
    }
}


