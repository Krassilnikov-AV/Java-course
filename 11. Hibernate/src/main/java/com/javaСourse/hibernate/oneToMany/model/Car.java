package com.javaСourse.hibernate.oneToMany.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Car {

	private int id;

	private String mark;

	private Integer cost;
}
