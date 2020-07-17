package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Basket;
import com.qa.ims.utils.Utils;

public class BasketDao implements Dao<Basket> {
	
	public static final Logger LOGGER = Logger.getLogger(BasketDao.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public BasketDao(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://" + Utils.MYSQL_URL + "/ims";
		this.username = username;
		this.password = password;
	}

	public BasketDao(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Basket BasketFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderitems = resultSet.getLong("orderitems");
		Long orderid = resultSet.getLong("orderid");
		Long customerid = resultSet.getLong("customerid");
		Long productid = resultSet.getLong("productid");
		Long quantity = resultSet.getLong("quantity");
		double price = resultSet.getDouble("price");
		return new Basket(orderitems, orderid, customerid, productid, quantity, price);
	}

	/**
	 * Reads all customers from the database
	 *
	 * @return A list of customers
	 */
	@Override
	public List<Basket> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from basket");) {
			ArrayList<Basket> basket = new ArrayList<>();
			while (resultSet.next()) {
				basket.add(BasketFromResultSet(resultSet));
			}
			return basket;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
			
		}
		return new ArrayList<>();
	}

	public Basket readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM basket ORDER BY orderid DESC LIMIT 1");) {
			resultSet.next();
			return BasketFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a customer in the database
	 *
	 * @param customer - takes in a customer object. id will be ignored
	 */
	@Override
	public Basket create(Basket basket) { {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into basket(orderid, customerid, productid, quantity, price) values('" + basket.getOrderid()
			+ "','" + basket.getCustomerid() + "','" + basket.getProductid() + "','" + basket.getQuantity() + "','" + basket.getPrice() + "')");
			
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		
		return null;
	}
	}

	public Basket readBasket(Long orderid) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM basket where orderid = '" + orderid + "';");) {
			resultSet.next();
			return BasketFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Basket orderTotal(Long orderid) {
		
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT SUM(price) FROM basket where orderid = '" + orderid + "';");) {
			resultSet.next();
			return BasketFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
		
	}


	/**
	 * Updates a customer in the database
	 *
	 * @param customer - takes in a customer object, the id field will be used to
	 *                 update that customer in the database
	 * @return
	 */
	@Override
	public Basket update(Basket basket) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("UPDATE basket set productid ='" + basket.getProductid()+ "', customerid ='"
					+ basket.getCustomerid() + "', productid ='" + basket.getProductid() + "', Quantity= '" +
					basket.getQuantity() + "', price = '" + basket.getPrice() + "' WHERE orderid = '" + basket.getOrderid() + "';");
			return readBasket(basket.getOrderid());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a customer in the database
	 *
	 * @param id - id of the customer
	 */
	@Override
	public void delete(long orderitems) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from basket where orderitems = " + orderitems);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

}
