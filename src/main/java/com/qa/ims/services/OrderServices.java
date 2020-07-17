//package com.qa.ims.services;
//
//import java.util.List;
//
//import com.qa.ims.persistence.dao.Dao;
//import com.qa.ims.persistence.domain.Order;
//
//public class OrderServices {
//	
//private Dao<Order> OrderDao;
//	
//	public OrderServices(Dao<Order> orderDao) {
//		this.OrderDao = orderDao;
//	}
//	
//	public List<Order> readAll() {
//		return OrderDao.readAll();
//	}
//
//	public Order create(Order order) {
//		return OrderDao.create(order);
//	}
//
//	public Order update(Order order) {
//		return OrderDao.update(order);
//	}
//
//	public void delete(Long id) {
//		OrderDao.delete(id);
//	}
//
//}
//
