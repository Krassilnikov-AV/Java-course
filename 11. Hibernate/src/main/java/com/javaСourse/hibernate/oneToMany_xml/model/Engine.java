package com.javaСourse.hibernate.oneToMany_xml.model;

import lombok.*;

import java.util.Set;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Engine {

	private int id;

	private String name;

	private int power;

	private String carMark;

	private Set<Car> cars;
}
