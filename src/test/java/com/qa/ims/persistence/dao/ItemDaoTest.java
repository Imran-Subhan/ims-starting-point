package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import com.qa.ims.Ims;
import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.ItemServices;

public class ItemDaoTest {
	
	
	/**
	 * The thing I want to fake functionality for
	 */
	@Mock
	private ItemServices itemServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy
	@InjectMocks
	private ItemController itemController;

	public static final Logger LOGGER = Logger.getLogger(Ims.class);
	static String jdbcurl = "jdbc:mysql://34.105.133.143:3306/ims_test?serverTimezone=UTC";
	static String username = "root";
	static String password = "2020";

//	@BeforeClass
//	public static void setup() {
//		try {
//			Connection connection = DriverManager.getConnection(jdbcurl, username, password);
//			Statement statement = connection.createStatement();
//			statement.executeUpdate("Drop database ims_test");
//
//		} catch (Exception e) {
//			LOGGER.debug(e.getStackTrace());
//			LOGGER.error(e.getMessage());
//		}
//	}

	@BeforeClass
	public static void aInit() {
		Ims ims = new Ims();
		ims.init("jdbc:mysql://34.105.133.143:3306/ims_test?serverTimezone=UTC", "root", "2020",
				"src/test/resources/sql-schema.sql");
	}

	@Test
	public void bCreateTest() {
		ItemDao ItemDao = new ItemDao(
				"jdbc:mysql://34.105.133.143:3306/ims_test?serverTimezone=UTC", "root", "2020");
		String productName = "Shirt";
		Double price = 7.0;
		Item item = new Item(1L, productName, price);
		String productName2 = "Jeans";
		Double price2 = 25.5;
		Item item2 = new Item(2L, productName2, price2);
		String productName3 = "Socks";
		Double price3 = 2.5;
		Item item3 = new Item(3L, productName3, price3);
		assertEquals(item, ItemDao.create(item));
		assertEquals(item2, ItemDao.create(item2));
		assertEquals(item3, ItemDao.create(item3));
	}

	@Test
	public void cReadAllTest() {
		ItemDao ItemDao = new ItemDao(
				"jdbc:mysql://34.105.133.143:3306/ims_test?serverTimezone=UTC", "root", "2020");
		List<Item> items = new ArrayList<>();
		items.add(new Item(1L, "Shirt", 7.0));
		items.add(new Item(2L, "Jeans", 25.5));
		items.add(new Item(3L, "Socks", 2.5));

		assertEquals(customers, customerDaoMysql.readAll());
	}

	@Test
	public void dReadLatestTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(
				"jdbc:mysql://34.105.133.143:3306/ims_test?serverTimezone=UTC", "root", "2020");
		Customer customer = new Customer(3L, "Bob", "Perry");
		assertEquals(customer, customerDaoMysql.readLatest());
	}

	@Test
	public void eReadCustomerTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(
				"jdbc:mysql://34.105.133.143:3306/ims_test?serverTimezone=UTC", "root", "2020");
		Customer customer = new Customer(2L, "James", "Peach");
		assertEquals(customer, customerDaoMysql.readCustomer(2L));
	}

//
//	/**
//	 * 
//	 */
	@Test
	public void fUpdateTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(
				"jdbc:mysql://34.105.133.143:3306/ims_test?serverTimezone=UTC", "root", "2020");
		Long id = 1L;
		String firstName = "Vinesh";
		String surname = "Ghela";
		Customer customer = new Customer((id), firstName, surname);
		assertEquals(customer, customerDaoMysql.update(customer));
	}

//	/**
//	 * makes sure that after you delete, the entry is no longer in the database.
//	 */
	@Test
	public void gDeleteTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(
				"jdbc:mysql://34.105.133.143:3306/ims_test?serverTimezone=UTC", "root", "2020");
		String id = "3";
		customerDaoMysql.delete(Long.parseLong(id));
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1L, "Vinesh", "Ghela"));
		customers.add(new Customer(2L, "James", "Peach"));
		assertEquals(customers, customerDaoMysql.readAll());
	}

	@AfterClass
	public static void cleanDB() {

		try (Connection connection = DriverManager.getConnection(jdbcurl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("drop table customers");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

}

