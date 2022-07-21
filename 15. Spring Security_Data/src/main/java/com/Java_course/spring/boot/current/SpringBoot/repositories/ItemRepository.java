package com.Java_course.spring.boot.current.SpringBoot.repositories;

/**
 * - JpaRepository является обобщеным интерфейсом
 * - ItemRepository работает с базой данных
 */
//@Repository
//public interface ItemRepository extends JpaRepository<Item, Long> {
//	/**
//	 * формирование запроса Spring Data, аналогичного SQL:
//	 * SELECT i FROM Item i WHERE i.title = 1?
//	 */
//	Item findByTitle(String title);
//
//	List<Item> findByCostBetween(int min, int max);
////	List<Item> findByActiveCostOrOrderByTitleDesc(String name, String surname);
//	/**
//	 * возможно поменять на свой метод созданным зпросом SqL*/
////	@Query(value = "", nativeQuery = true)
////	List<Item> myMethodName();
//	/**
//	 * Найти все Item-ы, у которых название заканчивается на какую то подстроку*/
//	@Query(value = "SELECT i FROM Item i WHERE i.title LIKE ?1%")
//	List<Item> findByTitleWith(String substr);
//}

/**
 * */

import com.Java_course.spring.boot.current.SpringBoot.entities.Item;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Long>, JpaSpecificationExecutor<Item> {

}
