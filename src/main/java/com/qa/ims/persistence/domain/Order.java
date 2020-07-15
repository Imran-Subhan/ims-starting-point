package com.qa.ims.persistence.domain;

public class Order {
	
	private Long orderid;
	private Double totalcost;
	
	public Order(Long orderid, Double totalcost) {
		
		this.orderid = orderid;
		this.totalcost = totalcost;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Double getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(Double totalcost) {
		this.totalcost = totalcost;
	}
	
	public String toString() {
		return "orderid: " + orderid + " total cost: " + totalcost;
	}
}
