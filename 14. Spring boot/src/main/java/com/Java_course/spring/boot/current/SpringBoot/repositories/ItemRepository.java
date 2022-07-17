package com.Java_course.spring.boot.current.SpringBoot.repositories;

import com.Java_course.spring.boot.current.SpringBoot.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * - JpaRepository является обобщеным интерфейсом
 * - ItemRepository работает с базой данных*/
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}