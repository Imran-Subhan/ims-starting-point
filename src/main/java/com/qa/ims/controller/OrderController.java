package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;


public class OrderController implements CrudController<Order>{

		public static final Logger LOGGER = Logger.getLogger(OrderController.class);
		
		private CrudServices<Order> orderService;
		
		public OrderController(CrudServices<Order> orderService) {
			this.orderService = orderService;
		}
		

		String getInput() {
			return Utils.getInput();
		}
		
		/**
		 * Reads all customers to the logger
		 */
		@Override
		public List<Order> readAll() {
			List<Order> orders = orderService.readAll();
			for(Order order: orders) {
				LOGGER.info(order.toString());
			}
			return orders;
		}

		/**
		 * Creates a customer by taking in user input
		 */
		@Override
		public Order create() {
//			LOGGER.info("Please enter an orderid");
//			String firstName = getInput();
//			LOGGER.info("Please enter a surname");
//			String surname = getInput();
//			Order customer = customerService.create(new Order(firstName, surname));
//			LOGGER.info("Customer created");
//			return customer;
		}

		/**
		 * Updates an existing customer by taking in user input
		 */
		@Override
		public Order update() {
			LOGGER.info("Please enter the id of the customer you would like to update");
			Long id = Long.valueOf(getInput());
			LOGGER.info("Please enter a first name");
			String firstName = getInput();
			LOGGER.info("Please enter a surname");
			String surname = getInput();
			Order customer = customerService.update(new Customer(id, firstName, surname));
			LOGGER.info("Customer Updated");
			return customer;
		}

		/**
		 * Deletes an existing customer by the id of the customer
		 */
		@Override
		public void delete() {
			LOGGER.info("Please enter the id of the customer you would like to delete");
			Long id = Long.valueOf(getInput());
			customerService.delete(id);
		}
		
	}
}
