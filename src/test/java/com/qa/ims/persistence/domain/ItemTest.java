package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ItemTest {
	
	private Item item;
	private Item item2;

	@Before
	public void setup() {
		item = new Item(12L, "t", 12D);
		item2 = new Item("t", 2D);
	}
	
	@Test
	public void SettersTest() {
		assertNotNull(item.getProductid());
		assertNotNull(item.getProductName());
		assertNotNull(item.getPrice());

		item.setProductid(null);
		assertNull(item.getProductid());
		item.setProductName(null);
		assertNull(item.getProductName());
		item.setPrice(0);
		assertNotNull(item.getPrice());
		
	}
		
	@Test
	@Ignore
	public void toStringTest() {
		String toString = "productid: 2 product name: top price: 1";
		assertEquals(toString, item.toString());
	}
	}
