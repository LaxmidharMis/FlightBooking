package com.order.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.order.entity.Order;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;

@RunWith(SpringRunner.class)
public class OrderServiceImplTest {

	@InjectMocks
	OrderService service;

	@Mock
	OrderRepository repository;

	@Test
	public void getAllOrderTest() {
		when(repository.findAll())
				.thenReturn(Stream.of(new Order(1, "Mobile", 20000, "Real me"), new Order(2, "Laptop", 80000, "Acer"))
						.collect(Collectors.toList()));
		assertEquals(2, service.getAllOrders().size());
	}

}
