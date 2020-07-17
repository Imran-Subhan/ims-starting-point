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

	public Basket(Long orderid, Double price) {
		this.orderid = orderid;
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





//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((customerid == null) ? 0 : customerid.hashCode());
//		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
//		result = prime * result + ((orderitemsid == null) ? 0 : orderitemsid.hashCode());
//		result = prime * result + ((price == null) ? 0 : price.hashCode());
//		result = prime * result + ((productid == null) ? 0 : productid.hashCode());
//		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
//		return result;
//	}





//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Basket other = (Basket) obj;
//		if (customerid == null) {
//			if (other.customerid != null)
//				return false;
//		} else if (!customerid.equals(other.customerid))
//			return false;
//		if (orderid == null) {
//			if (other.orderid != null)
//				return false;
//		} else if (!orderid.equals(other.orderid))
//			return false;
//		if (orderitemsid == null) {
//			if (other.orderitemsid != null)
//				return false;
//		} else if (!orderitemsid.equals(other.orderitemsid))
//			return false;
//		if (price == null) {
//			if (other.price != null)
//				return false;
//		} else if (!price.equals(other.price))
//			return false;
//		if (productid == null) {
//			if (other.productid != null)
//				return false;
//		} else if (!productid.equals(other.productid))
//			return false;
//		if (quantity == null) {
//			if (other.quantity != null)
//				return false;
//		} else if (!quantity.equals(other.quantity))
//			return false;
//		return true;
//	}
	
}


