package com.qa.ims.persistence.domain;

public class Basket {
	
	private Long orderitemsid;
	private Long orderid;
	private Long customerid;
	private Long productid;
	private Long quantity;
	private Double price;


	public Basket(Long orderitemsid, Long orderid, Long customerid, Long productid, Long quantity, Double price) {
		this.orderitemsid = orderitemsid;
		this.orderid = orderid;
		this.customerid = customerid;
		this.productid = productid;
		this.quantity = quantity;
		this.price = price;
	}

	
	


	public Basket(Long orderid, Long customerid, Long productid, Long quantity, Double price) {
		this.orderid = orderid;
		this.customerid = customerid;
		this.productid = productid;
		this.quantity = quantity;
		this.price = price;
	}





	public Long getOrderitemsid() {
		return orderitemsid;
	}


	public void setOrderitemsid(Long orderitemsid) {
		this.orderitemsid = orderitemsid;
	}


	public Long getOrderid() {
		return orderid;
	}


	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}


	public Long getCustomerid() {
		return customerid;
	}


	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}


	public Long getProductid() {
		return productid;
	}


	public void setProductid(Long productid) {
		this.productid = productid;
	}


	public Long getQuantity() {
		return quantity;
	}


	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String toString() {
		return "orderitemsid: " + orderitemsid + " orderid: " + orderid + " customerid: " + customerid + " productid: " + productid + " quantity: " + quantity + " price: " + price;
	}
	
}


