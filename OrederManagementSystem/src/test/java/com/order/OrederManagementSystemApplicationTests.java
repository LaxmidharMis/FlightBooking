package com.order;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.order.entity.Order;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrederManagementSystemApplicationTests {

//	@Autowired
//	private OrderService service;

	@Autowired
	private OrderRepository repository;

//	@Test
//	public void getAllOrderTest() {
//		when(repository.findAll())
//				.thenReturn(Stream.of(new Order(1, "Mobile", 20000, "Real me"), new Order(2, "Laptop", 80000, "Acer"))
//						.collect(Collectors.toList()));
//		assertEquals(2, service.getAllOrders().size());
//	}
//
//	@Test
//	void contextLoads() {
//	}
	
	@Test
	public void getAllOrderTest() {
		Order order= new Order();
		order.setOrderId(1);
		order.setOrderName("Buy a Mobile..... ");
		order.setOrderPrice(20000);
		order.setOrderBrand("Oppo");
		repository.save(order);
		assertNotNull(repository.findById(1).get());
	}

}
