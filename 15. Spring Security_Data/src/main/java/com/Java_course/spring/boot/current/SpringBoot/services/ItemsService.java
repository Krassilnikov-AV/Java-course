package com.Java_course.spring.boot.current.SpringBoot.services;

import com.Java_course.spring.boot.current.SpringBoot.entities.Item;
import com.Java_course.spring.boot.current.SpringBoot.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService {
	private ItemRepository itemRepository;

	@Autowired
	public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public List<Item> getAllItems() {
		// получение в консоли данных по названию, вытащенных из БД при помощи Spring DAta
		System.out.println(itemRepository.findByTitle("Tree"));
		System.out.println(itemRepository.findByCostBetween(30, 70));
		System.out.println(itemRepository.findByTitleWith("House"));
		/**смотреть данные, на 5-ой странице в количестве 20 шт*/
		itemRepository.findAll(PageRequest.of(5, 20));

		return itemRepository.findAll();
	}
}