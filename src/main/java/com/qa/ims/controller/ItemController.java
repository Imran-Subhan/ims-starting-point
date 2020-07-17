package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;


import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {
	
	public static final Logger LOGGER = Logger.getLogger(ItemController.class);
	
	private CrudServices<Item> ItemService;
	
	public ItemController(CrudServices<Item> ItemService) {
		this.ItemService = ItemService;
	}
	

	String getInput() {
		return Utils.getInput();
	}
	
	 Integer getIntInput() {
		return Utils.getintInput();
	 }
	
	Long getLonginput() {
		return Utils.getLongInput();
	}
	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = ItemService.readAll();
		for(Item item: items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter a product name");
		String productName = getInput();
		LOGGER.info("Please enter a price");
		Double price = Double.valueOf(getInput());
		Item item = ItemService.create(new Item(productName, price));
		LOGGER.info("Item created");
		return item;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the product you would like to update");
		Long productid = Long.valueOf(getInput());
		LOGGER.info("Please enter product name");
		String productName = getInput();
		LOGGER.info("Please enter a price");
		Double price = Double.valueOf(getInput());
		Item item = ItemService.update(new Item(productid, productName, price));
		LOGGER.info("Item Updated");
		return item;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the product you would like to delete");
		Long productid = Long.valueOf(getInput());
		ItemService.delete(productid);
	}
	
}
	

