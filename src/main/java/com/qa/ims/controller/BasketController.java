package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Basket;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class BasketController implements CrudController<Basket> {


	public static final Logger LOGGER = Logger.getLogger(BasketController.class);
	

	private CrudServices<Basket> BasketService;
	
	public BasketController(CrudServices<Basket> BasketService) {
		this.BasketService = BasketService;
	}
	

	String getInput() {
		return Utils.getInput();
	}
	
	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Basket> readAll() {
		List<Basket> basket = BasketService.readAll();
		for(Basket Basket: basket) {
			LOGGER.info(Basket.toString());
		}
		System.out.println("        ");
		return basket;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Basket create() {
		LOGGER.info("Please enter a orderID");
		Long orderid = Long.valueOf(getInput());
		LOGGER.info("Please enter a customerID");
		Long customerid = Long.valueOf(getInput());
		LOGGER.info("Please enter a productID");
		Long productid = Long.valueOf(getInput());
		LOGGER.info("Please enter a quantity");
		Long quantity = Long.valueOf(getInput());
		LOGGER.info("Please enter a price");
		Double price = Double.valueOf(getInput());
		Basket basket = BasketService.create(new Basket(orderid, customerid, productid, quantity, price));
		LOGGER.info("Item added to basket");
		return basket;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Basket update() {
		LOGGER.info("Please enter which orderID you want to update");
		Long orderid = Long.valueOf(getInput());
		LOGGER.info("Please enter an updated productid ");
		Long productid = Long.valueOf(getInput());
		LOGGER.info("Please enter an updated customerID");
		Long customerid = Long.valueOf(getInput());
		LOGGER.info("Please enter an updated quantity");
		Long quantity = Long.valueOf(getInput());
		LOGGER.info("Please enter an updated price");
		Double price = Double.valueOf(getInput());
		
		Basket basket = BasketService.update(new Basket(orderid, customerid, productid, quantity, price));
		LOGGER.info("Basket Updated");
		System.out.println("            ");
		return basket;
		
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the orderitems id you would like to delete");
		Long orderitemsid = Long.valueOf(getInput());
		BasketService.delete(orderitemsid);
		LOGGER.info("Basket field deleted");
	}

		
	
		
	}


