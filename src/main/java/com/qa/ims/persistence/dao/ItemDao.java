package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemDao implements Dao<Item> {
	
	public static final Logger LOGGER = Logger.getLogger(ItemDao.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public ItemDao(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://" + Utils.MYSQL_URL + "/ims";
		this.username = username;
		this.password = password;
	}

	public ItemDao(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Item ItemFromResultSet(ResultSet resultSet) throws SQLException {
		Long productid = resultSet.getLong("productid");
		String productName = resultSet.getString("productName");
		double price = resultSet.getDouble("price");
		return new Item(productid, productName, price);
	}

	/**
	 * Reads all customers from the database
	 *
	 * @return A list of customers
	 */
	@Override
	public List<Item> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from items");) {
			ArrayList<Item> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(ItemFromResultSet(resultSet));
			}
			return items;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Item readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY productid DESC LIMIT 1;");) {
			resultSet.next();
			return ItemFromResultSet(resultSet);
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
	public Item create(Item item) { {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into items(productName, price) values('" + item.getProductName() 
			+ "','" + item.getPrice() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	}

	public Item readItem(Long productid) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items where productid = " + productid + ";");) {
			resultSet.next();
			return ItemFromResultSet(resultSet);
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
	public Item update(Item item) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update items set productName ='" + item.getProductName() + "', price ='"
					+ item.getPrice() + "' where productid =" + item.getProductid() + ";");
			return readItem(item.getProductid());
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
	public void delete(long productid) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from items where productid = " + productid);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
}



