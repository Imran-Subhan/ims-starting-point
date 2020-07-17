package com.qa.ims.controller;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.ItemDao;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.ItemServices;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	
	@Mock
	private ItemServices itemServices;
	
	@Spy // for the methods in customerController
	@InjectMocks // for any classes our customerController calls (in this case customerService)
	private ItemController itemController;

	@Test
	public void readAllTest() {
		ItemController itemController = new ItemController(itemServices);
		List<Item> items = new ArrayList<>();
		items.add(new Item("Hat", 1.0));
		items.add(new Item("Top", 2.0));
		items.add(new Item("Shoe", 3.0));
		Mockito.when(itemServices.readAll()).thenReturn(items);
		assertEquals(items, itemController.readAll());
	}

	@Test
	@Ignore
	public void createTest() {
		String productName = "Shoe";
		Double price = 3.0;
		Mockito.doReturn(productName).when(itemController).getInput();
		Item item = new Item(productName, price);
		Item saveditem = new Item(3L, "Shoe", 3.0);
		Mockito.when(itemServices.create(item)).thenReturn(saveditem);
		assertEquals(saveditem, itemController.create());
	}

	/**
	 *
	 */
	@Test
	@Ignore
	public void updateTest() {
		Long productid = 1L;
		String productName = "Hat";
		Double price = 1.0D;
		Mockito.doReturn(productid, productName, price).when(itemController).getInput();
		Mockito.doReturn(productid, productName, price).when(itemController).getInput();
		Item item = new Item(1L, productName, price);
		Mockito.when(itemServices.update(item)).thenReturn(item);
		assertEquals(item, itemController.update());
	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
	@Test
	@Ignore
	public void deleteTest() {
		Long productid = 1L;
		Mockito.doReturn(productid).when(itemController).getInput();
		itemController.delete();
		Mockito.verify(itemServices, Mockito.times(1)).delete(1L);
	}

	
}

//	@Test
//	public void readAllTest() {
//		this.itemDao = new ItemDao(null, null);
//		this.itemServices = new ItemServices(itemDao);
//		this.itemController = new ItemController(itemServices);
//		
//		List<Item> items = new ArrayList<>();
//		items.add(new Item("T-shirt", 3.0));
//		items.add(new Item("Jeans", 4.2));
//		items.add(new Item("Jacket", 20.40));
//		Mockito.when(itemServices.readAll()).thenReturn(items);
//		assertEquals(items, itemController.readAll());
//	}

//	@Test
//	public void createTest() {
//		String firstName = "Chris";
//		String surname = "Perrins";
//		Mockito.doReturn(firstName, surname).when(customerController).getInput();
//		Customer customer = new Customer(firstName, surname);
//		Customer savedCustomer = new Customer(1L, "Chris", "Perrins");
//		Mockito.when(customerServices.create(customer)).thenReturn(savedCustomer);
//		assertEquals(savedCustomer, customerController.create());
//	}
//
//	/**
//	 *
//	 */
//	@Test
//	public void updateTest() {
//		String id = "1";
//		String firstName = "Rhys";
//		String surname = "Thompson";
//		Mockito.doReturn(id, firstName, surname).when(customerController).getInput();
//		Customer customer = new Customer(1L, firstName, surname);
//		Mockito.when(customerServices.update(customer)).thenReturn(customer);
//		assertEquals(customer, customerController.update());
//	}
//
//	/**
//	 * Delete doesn't return anything, so we can just verify that it calls the
//	 * delete method
//	 */
//	@Test
//	public void deleteTest() {
//		String id = "1";
//		Mockito.doReturn(id).when(customerController).getInput();
//		customerController.delete();
//		Mockito.verify(customerServices, Mockito.times(1)).delete(1L);
//	}

	

