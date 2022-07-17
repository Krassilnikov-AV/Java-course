package com.Java_course.spring.boot.current.SpringBoot.controllers;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat {
	private Long id;
	private String name;
	private String color;

	public Cat(Long id, String name) {
		this.id = id;
		this.name = name;
	}
}
