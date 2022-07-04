package com.order.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.Order;
import com.order.service.OrderService;

@CrossOrigin(origins = "*")
@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/createOrders")
	public Integer createEmployee(@RequestBody Order order) {
		Integer id = orderService.createOrder(order);
		System.out.println("Order is created with id...." + id);
		return id;

	}

	@GetMapping("/getAllOrders")
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping("/singleOrder/{id}")
	public Optional<Order> getOrder(@PathVariable Integer id) {
		Optional<Order> order = orderService.getOrder(id);
		return order;
	}

	@DeleteMapping("/deleteOrder/{id}")
	public ResponseEntity<Order> deleteOrder(@PathVariable Integer id) {
		System.out.println("Deleted order id is...." + id);
		ResponseEntity<Order> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			orderService.deletOrder(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		}

		return responseEntity;
	}

	@PutMapping("/updateOrder/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable Integer id, @RequestBody Order order) {
		System.out.println("Updated order id...."+id);
		ResponseEntity<Order> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			orderService.updateOrder(order, id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		}

		return responseEntity;
	}

}
