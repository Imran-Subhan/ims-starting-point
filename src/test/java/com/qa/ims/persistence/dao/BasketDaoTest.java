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
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.Ims;
import com.qa.ims.controller.BasketController;
import com.qa.ims.controller.CustomerController;
import com.qa.ims.persistence.dao.BasketDao;
import com.qa.ims.persistence.domain.Basket;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.services.BasketServices;
import com.qa.ims.services.CustomerServices;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BasketDaoTest {
	
	/**
	 * The thing I want to fake functionality for
	 */
	@Mock
	private CustomerServices customerServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy
	@InjectMocks
	private CustomerController customerController;

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
	@Ignore
	public void bCreateTest() {
		BasketDao BasketDao = new BasketDao(
				"jdbc:mysql://34.105.133.143:3306/ims_test?serverTimezone=UTC", "root", "2020");
		
		Long orderitemsid =1L;
		Long orderid = 1L;
		Long customerid = 1L ;
		Long productid = 1L;
		Long quantity = 1L;
		Double price = 1.0;
		Basket basket = new Basket(orderitemsid, orderid, customerid, productid, quantity, price);
		
		Long orderid1 = 2L;
		Long customerid1 = 2L ;
		Long productid1 = 2L;
		Long quantity1 = 2L;
		Double price1 = 2.0;
		Basket basket1 = new Basket(2L, orderid1, customerid1, productid1, quantity1, price1);
		
		Long orderid2 = 3L;
		Long customerid2 = 3L ;
		Long productid2 = 3L;
		Long quantity2 = 3L;
		Double price2 = 3.0;
		Basket basket2 = new Basket(3L, orderid2, customerid2, productid2, quantity2, price2);
		
		assertEquals(basket, BasketDao.create(basket));
		assertEquals(basket1, BasketDao.create(basket1));
		assertEquals(basket2, BasketDao.create(basket2));
	}

	@Test
	@Ignore
	public void cReadAllTest() {
		BasketDao BasketDao = new BasketDao(
				"jdbc:mysql://34.105.133.143:3306/ims_test?serverTimezone=UTC", "root", "2020");
		List<Basket> basket = new ArrayList<>();
		basket.add(new Basket(1L, 1L, 1L, 1L, 1L, 1.0D));
		basket.add(new Basket(2L, 2L, 2L, 2L, 2L, 2.0D));
		basket.add(new Basket(3L, 3L, 3L, 3L, 3L, 3.0D));

		assertEquals(basket, BasketDao.readAll());
	}

	@Test
	@Ignore
	public void dReadLatestTest() {
		BasketDao BasketDao = new BasketDao(
				"jdbc:mysql://34.105.133.143:3306/ims_test?serverTimezone=UTC", "root", "2020");
		Basket basket = new Basket(2L, 2L, 2L, 2L, 2L, 2.0D);
		assertEquals(basket, BasketDao.readLatest());
	}

	@Test
	@Ignore
	public void eReadBasketTest() {
		BasketDao BasketDao = new BasketDao(
				"jdbc:mysql://34.105.133.143:3306/ims_test?serverTimezone=UTC", "root", "2020");
		Basket basket = new Basket(2L, 2L, 2L, 2L, 2L, 2.0D);
		assertEquals(basket, BasketDao.readBasket(2L));
	}

//
//	/**
//	 * 
//	 */
	@Test
	@Ignore
	public void fUpdateTest() {
		BasketDao BasketDao = new BasketDao(
				"jdbc:mysql://34.105.133.143:3306/ims_test?serverTimezone=UTC", "root", "2020");
		Long orderid = 1L;
		Long customerid = 1L;
		Long productid = 1L;
		Long quantity = 1L;
		Double price = 1.0D;

		Basket basket = new Basket(1L, orderid, customerid, productid, quantity, price);
		assertEquals(basket, BasketDao.update(basket));
	}

//	/**
//	 * makes sure that after you delete, the entry is no longer in the database.
//	 */
	@Test
	@Ignore
	public void gDeleteTest() {
		BasketDao BasketDao = new BasketDao(
				"jdbc:mysql://34.105.133.143:3306/ims_test?serverTimezone=UTC", "root", "2020");
		String orderid = "2";
		BasketDao.delete(Long.parseLong(orderid));
		List<Basket> basket = new ArrayList<>();
		basket.add(new Basket(1L, 1L, 1L, 1L, 1L, 1D));
		basket.add(new Basket(1L, 1L, 1L, 1L, 1L, 1D));
		assertEquals(basket, BasketDao.readAll());
	}

	@AfterClass
	public static void cleanDB() {

		try (Connection connection = DriverManager.getConnection(jdbcurl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("drop table basket");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

}

