package com.Java_course.spring.boot.current.SpringBoot.repositories.specification;


import com.Java_course.spring.boot.current.SpringBoot.entities.Item;
import org.springframework.data.jpa.domain.Specification;

public class ItemsSpecs {

	public static Specification<Item> titleContains(String word) {
		return (Specification<Item>) (root, criteriaQuery, criterianBuilder) -> criterianBuilder.like(root.get("title"), "%"+word+"%");
	}

	public static Specification<Item> costGreaterThanOrEq(int value) {
		return (Specification<Item>) (root, criteriaQuery, criterianBuilder) -> {
			return criterianBuilder.greaterThanOrEqualTo(root.get("cost"), value);
		};
	}
}