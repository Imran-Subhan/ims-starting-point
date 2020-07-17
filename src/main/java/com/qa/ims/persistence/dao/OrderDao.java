//
//package com.qa.ims.persistence.dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import org.apache.log4j.Logger;
//
//import com.qa.ims.persistence.domain.Basket;
//import com.qa.ims.persistence.domain.Customer;
//import com.qa.ims.persistence.domain.Order;
//import com.qa.ims.utils.Utils;
//
//
//public class OrderDao implements Dao<Order> { 
//	
//	public static final Logger LOGGER = Logger.getLogger(OrderDao.class);
//
//	private String jdbcConnectionUrl;
//	private String username;
//	private String password;
//
//	public OrderDao(String username, String password) {
//		this.jdbcConnectionUrl = "jdbc:mysql://" + Utils.MYSQL_URL + "/ims";
//		this.username = username;
//		this.password = password;
//	}
//
//	public OrderDao(String jdbcConnectionUrl, String username, String password) {
//		this.jdbcConnectionUrl = jdbcConnectionUrl;
//		this.username = username;
//		this.password = password;
//	}
//
//	Order OrderFromResultSet(ResultSet resultSet) throws SQLException {
//	
//		Long orderid = resultSet.getLong("orderid");
//		double price = resultSet.getDouble("price");
//		return new Order(orderid, price);
//	}
//
//	/**
//	 * Reads all customers from the database
//	 *
//	 * @return A list of customers
//	 */
//	@Override
//	public List<Order> readAll() {
//		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
//				Statement statement = connection.createStatement();
//				ResultSet resultSet = statement.executeQuery("select * from basket");) {
//			ArrayList<Order> order = new ArrayList<>();
//			while (resultSet.next()) {
//				order.add(OrderFromResultSet(resultSet));
//			}
//			return order;
//		} catch (SQLException e) {
//			LOGGER.debug(e.getStackTrace());
//			LOGGER.error(e.getMessage());
//			
//		}
//		return new ArrayList<>();
//	}
//
//	public Order readLatest() {
//		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
//				Statement statement = connection.createStatement();
//				ResultSet resultSet = statement.executeQuery("SELECT * FROM order ORDER BY orderid DESC LIMIT 1");) {
//			resultSet.next();
//			return OrderFromResultSet(resultSet);
//		} catch (Exception e) {
//			LOGGER.debug(e.getStackTrace());
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}
//
//	/**
//	 * Creates a customer in the database
//	 *
//	 * @param customer - takes in a customer object. id will be ignored
//	 */
//	@Override
//	public Order create(Order order) { {
//		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
//				Statement statement = connection.createStatement();) {
//			statement.executeUpdate("insert into order(orderid, totalcost) values('" + order.getOrderid()
//			+ "','" + order.getTotalcost() + "')");
//			
//			return readLatest();
//		} catch (Exception e) {
//			LOGGER.debug(e.getStackTrace());
//			LOGGER.error(e.getMessage());
//		}
//		
//		return null;
//	}
//	}
//
//	public Order readBasket(Long orderid) {
//		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
//				Statement statement = connection.createStatement();
//				ResultSet resultSet = statement.executeQuery("SELECT * FROM order where orderid = '" + orderid + "';");) {
//			resultSet.next();
//			return OrderFromResultSet(resultSet);
//		} catch (Exception e) {
//			LOGGER.debug(e.getStackTrace());
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}
//
////	public Basket orderTotal(Long orderid) {
////		
////		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
////				Statement statement = connection.createStatement();
////				ResultSet resultSet = statement.executeQuery("SELECT SUM(price) FROM basket where orderid = '" + orderid + "';");) {
////			resultSet.next();
////			return OrderFromResultSet(resultSet);
////		} catch (Exception e) {
////			LOGGER.debug(e.getStackTrace());
////			LOGGER.error(e.getMessage());
////		}
////		return null;
////		
////	}
//
//
//	/**
//	 * Updates a customer in the database
//	 *
//	 * @param customer - takes in a customer object, the id field will be used to
//	 *                 update that customer in the database
//	 * @return
//	 */
//	@Override
//	public Order update(Order order) {
//		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
//				Statement statement = connection.createStatement();) {
//			statement.executeUpdate("UPDATE order set orderid ='" + order.getOrderid() + "', price = '" + order.getTotalcost() + "' WHERE orderid = '" + order.getOrderid() + "';");
//			return readBasket(order.getOrderid());
//		} catch (Exception e) {
//			LOGGER.debug(e.getStackTrace());
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}
//
//	/**
//	 * Deletes a customer in the database
//	 *
//	 * @param id - id of the customer
//	 */
//	@Override
//	public void delete(long orderid) {
//		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
//				Statement statement = connection.createStatement();) {
//			statement.executeUpdate("delete from order where orderid = " + orderid);
//		} catch (Exception e) {
//			LOGGER.debug(e.getStackTrace());
//			LOGGER.error(e.getMessage());
//		}
//	}
//
//
//}