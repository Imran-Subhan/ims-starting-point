package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BasketTest {
	
	private Basket basket;
	private Basket basket2;
	
	@Before
	public void setup() {
		basket = new Basket(23L, 45L, 12L, 1L, 34D);
		basket2 = new Basket(23L, 45L, 12L, 1L, 43L, 34D);
	}
	
	@Test
	public void SettersTest() {
		assertNotNull(basket.getOrderid());
		assertNotNull(basket.getCustomerid());
		assertNotNull(basket.getProductid());
		assertNotNull(basket.getQuantity());
		assertNotNull(basket.getPrice());
		
		assertNotNull(basket2.getOrderitemsid());
		assertNotNull(basket2.getOrderid());
		assertNotNull(basket2.getCustomerid());
		assertNotNull(basket2.getProductid());
		assertNotNull(basket2.getQuantity());
		assertNotNull(basket2.getPrice());
		
		basket.setOrderid(null);
		assertNull(basket.getOrderid());
		basket.setCustomerid(null);
		assertNull(basket.getCustomerid());
		basket.setProductid(null);
		assertNull(basket.getProductid());
		basket.setQuantity(null);
		assertNull(basket.getQuantity());
		basket.setPrice(null);
		assertNull(basket.getPrice());
		
		basket2.setOrderitemsid(null);
		assertNull(basket2.getOrderitemsid());
		basket2.setOrderid(null);
		assertNull(basket2.getOrderid());
		basket2.setCustomerid(null);
		assertNull(basket2.getCustomerid());
		basket2.setProductid(null);
		assertNull(basket2.getProductid());
		basket2.setQuantity(null);
		assertNull(basket2.getQuantity());
		basket2.setPrice(null);
		assertNull(basket2.getPrice());
	}
		@Test
		@Ignore
		public void toStringTest() {
			String toString = "Orderid: 1 Customerid: 2 Productid: 3 Quantity: 4 Price: 5";
			assertEquals(toString, basket.toString());
		}



		
		
	}

