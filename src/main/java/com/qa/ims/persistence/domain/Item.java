package com.qa.ims.persistence.domain;

public class Item {
	
	private Long productid;
	private String productName;
	private Double price;
	private String price2;

	public Item(String productName, Double price) {
		this.productName = productName;
		this.price = price;
	}

	public Item(Long productid, String productName, Double price) {
		this.productid = productid;
		this.productName = productName;
		this.price = price;
	}


	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return "productid: " + productid + " product name: " + productName + " price: " + price;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
//		result = prime * result + ((productid == null) ? 0 : productid.hashCode());
//		result = prime * result + ((price == null) ? 0 : price.hashCode());
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productid == null) {
			if (other.productid != null)
				return false;
		} else if (!productid.equals(other.productid))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

		
	}



