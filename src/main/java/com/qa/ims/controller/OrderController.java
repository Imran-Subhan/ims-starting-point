//package com.qa.ims.controller;
//
//import java.util.List;
//
//import org.apache.log4j.Logger;
//
//import com.qa.ims.persistence.domain.Order;
//import com.qa.ims.services.CrudServices;
//import com.qa.ims.services.OrderServices;
//import com.qa.ims.utils.Utils;
//
//
//public class OrderController implements CrudController<Order>{
//
//	public static final Logger LOGGER = Logger.getLogger(OrderController.class);
//	
//
//	private CrudServices<Order> OrderService;
//	
//	public OrderController(CrudServices<Order> OrderService) {
//		this.OrderService = OrderService;
//	}
//	
//
////	public OrderController(OrderServices orderServices) {
////		// TODO Auto-generated constructor stub
////	}
//
//
//	String getInput() {
//		return Utils.getInput();
//	}
//	
//	/**
//	 * Reads all customers to the logger
//	 */
//	@Override
//	public List<Order> readAll() {
//		List<Order> Orders = OrderService.readAll();
//		for(Order order: Orders) {
//			LOGGER.info(order.toString());
//		}
//		return Orders;
//	}
//
//	/**
//	 * Creates a customer by taking in user input
//	 */
//	@Override
//	public Order create() {
//		LOGGER.info("Please enter a orderID");
//		Long orderid = Long.valueOf(getInput());
//		LOGGER.info("Please enter a price");
//		Double price = Double.valueOf(getInput());
//		Order order = OrderService.create(new Order(orderid, price));
//		LOGGER.info("Item added to basket");
//		
//		return order;
//	}
//
//	/**
//	 * Updates an existing customer by taking in user input
//	 */
//	@Override
//	public Order update() {
//		LOGGER.info("Please enter which orderID you want to update");
//		Long orderid = Long.valueOf(getInput());
//		LOGGER.info("Please enter an updated price");
//		Double price = Double.valueOf(getInput());
//		
//		Order order = OrderService.update(new Order(orderid, price));
//		LOGGER.info("Order Updated");
//		System.out.println("            ");
//		return order;
//		
//	}
//
//	/**
//	 * Deletes an existing customer by the id of the customer
//	 */
//	@Override
//	public void delete() {
//		LOGGER.info("Please enter the id of the product you would like to delete");
//		Long orderid = Long.valueOf(getInput());
//		OrderService.delete(orderid);
//		LOGGER.info("Order field deleted");
//	}
//		
//	}
//

