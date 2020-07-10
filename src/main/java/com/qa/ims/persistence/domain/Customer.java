package com.qa.ims.persistence.domain;

public class Customer {

	private Long customerID;
	private String FullName;
	private String email;
	private Long Mobile;
	private String Address;
	private String PostCode;


	public Customer(Long id, String FullName, String email, Long Mobile, String Address, String PostCode) {
		this.customerID = id;
		this.FullName = FullName;
		this.email = email;
		this.Mobile = Mobile;
		this.Address = Address;
		this.PostCode = PostCode;
	}



	public Long getcustomerID() {
		return customerID;
	}



	public void setcustomerID(Long customerID) {
		this.customerID = customerID;
	}



	public String getFullName() {
		return FullName;
	}



	public void setFullName(String FullName) {
		this.FullName = FullName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Long getMobile() {
		return Mobile;
	}



	public void setMobile(Long Mobile) {
		this.Mobile = Mobile;
	}



	public String getAddress() {
		return Address;
	}



	public void setAddress(String Address) {
		this.Address = Address;
	}



	public String getPostCode() {
		return PostCode;
	}



	public void setPostCode(String PostCode) {
		this.PostCode = PostCode;
	}



	public String toString() {
		return "CustomerID:" + customerID + " Full name:" + FullName + " e-mail:" + email + " Mobile:" + Mobile + " Address:" + Address + " Post Code:" + PostCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FullName == null) ? 0 : FullName.hashCode());
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((Mobile == null) ? 0 : Mobile.hashCode());
		result = prime * result + ((Address == null) ? 0 : Address.hashCode());
		result = prime * result + ((PostCode == null) ? 0 : PostCode.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (FullName == null) {
			if (other.FullName != null)
				return false;
		} else if (!FullName.equals(other.FullName))
			return false;
		if (customerID == null) {
			if (other.customerID != null)
				return false;
		} else if (!customerID.equals(other.customerID))
			return false;
//		if (surname == null) {
//			if (other.surname != null)
//				return false;
//		} else if (!surname.equals(other.surname))
//			return false;
		return true;
	}

}
