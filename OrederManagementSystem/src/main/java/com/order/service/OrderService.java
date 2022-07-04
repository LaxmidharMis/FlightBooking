package com.order.service;

import java.util.List;
import java.util.Optional;

import com.order.entity.Order;

public interface OrderService {

	public Integer createOrder(Order order);

	public List<Order> getAllOrders();

	public Optional<Order> getOrder(Integer id);

	public void deletOrder(Integer id);

	public Integer updateOrder(Order order, Integer id);

}
