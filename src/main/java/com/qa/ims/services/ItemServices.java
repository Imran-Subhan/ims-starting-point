package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Item;


public class ItemServices implements CrudServices<Item> {

		private Dao<Item> ItemDao;
		
		public ItemServices(Dao<Item> ItemDao) {
			this.ItemDao = ItemDao;
		}
		
		public List<Item> readAll() {
			return ItemDao.readAll();
		}

		public Item create(Item item) {
			return ItemDao.create(item);
		}

		public Item update(Item item) {
			return ItemDao.update(item);
		}

		public void delete(Long productid) {
			ItemDao.delete(productid);
		}

	}

