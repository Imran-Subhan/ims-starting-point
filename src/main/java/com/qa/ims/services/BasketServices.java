package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Basket;

public class BasketServices implements CrudServices<Basket> {

		private Dao<Basket> BasketDao;
		
		public BasketServices(Dao<Basket> BasketDao) {
			this.BasketDao = BasketDao;
		}
		
		public List<Basket> readAll() {
			return BasketDao.readAll();
		}

		public Basket create(Basket basket) {
			return BasketDao.create(basket);
		}

		public Basket update(Basket basket) {
			return BasketDao.update(basket);
		}

		public void delete(Long orderitemsid) {
			BasketDao.delete(orderitemsid);
		}

	}

