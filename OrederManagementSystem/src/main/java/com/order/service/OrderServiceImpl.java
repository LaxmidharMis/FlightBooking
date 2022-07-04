package com.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.order.entity.Order;
import com.order.exception.OrederNotFoundException;
import com.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Override
	public Integer createOrder(Order order) {
		Order createOrder = orderRepo.save(order);
		return createOrder.getOrderId();
	}

	@Override
	public List<Order> getAllOrders() {

		return orderRepo.findAll();
	}

	@Override
	public Optional<Order> getOrder(Integer id) {

		return orderRepo.findById(id);
	}

	@Override
	public void deletOrder(Integer id) {

		orderRepo.deleteById(id);

	}

	@Override
	public Integer updateOrder(Order order, Integer id) {
		Order existingOrder = orderRepo.findById(id).orElseThrow(() -> new OrederNotFoundException("Order not found for id..." +id+HttpStatus.NOT_FOUND));
	//	Order existingOrder = orderRepo.findById(id).orElseThrow();
		existingOrder.setOrderId(order.getOrderId());
		existingOrder.setOrderName(order.getOrderName());
		existingOrder.setOrderPrice(order.getOrderPrice());
		existingOrder.setOrderBrand(order.getOrderBrand());

		orderRepo.save(existingOrder);
		return existingOrder.getOrderId();
	}

}
