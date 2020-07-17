//package com.qa.ims.controller;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Spy;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.qa.ims.persistence.domain.Basket;
//import com.qa.ims.services.BasketServices;
//
//@RunWith(MockitoJUnitRunner.class)
//public class BasketControllerTest {
//	/**
//	 * The thing I want to fake functionlity for
//	 */
//	@Mock
//	private BasketServices basketServices;
//
//	/**
//	 * Spy is used because i want to mock some methods inside the item I'm testing
//	 * InjectMocks uses dependency injection to insert the mock into the customer
//	 * controller
//	 */
//	@Spy // for the methods in customerController
//	@InjectMocks // for any classes our customerController calls (in this case customerService)
//	private BasketController basketController;
//
//	@Test
//	public void readAllTest() {
//		BasketController BasketController = new BasketController(basketServices);
//		List<Basket> basket = new ArrayList<>();
//		basket.add(new Basket("Chris", "P"));
//		basket.add(new Basket("Rhys", "T"));
//		customers.add(new Customer("Nic", "J"));
//		Mockito.when(customerServices.readAll()).thenReturn(customers);
//		assertEquals(customers, customerController.readAll());
//	}
//
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
//
//	
//}

