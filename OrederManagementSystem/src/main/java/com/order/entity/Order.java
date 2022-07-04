package com.order.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name ="order_tbl")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private String orderName;
	private double orderPrice;
	private String orderBrand;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Integer orderId, String orderName, double orderPrice, String orderBrand) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderPrice = orderPrice;
		this.orderBrand = orderBrand;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderBrand() {
		return orderBrand;
	}

	public void setOrderBrand(String orderBrand) {
		this.orderBrand = orderBrand;
	}

}
