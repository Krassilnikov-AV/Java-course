/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.javaСourse.hibernate.library_books;


import lombok.*;

import javax.persistence.*;

@Data
@Entity // аннотация сущность, говорит о том что объекты данного класса смогут маппиться с БД
// !!! обязательно дефолтный конструктор
@NoArgsConstructor   // необходимо всегда явно объявлять
@Table(name = "catalogs") // таблица и ее имя
public class Catalog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "title")
	private String title;

	public Catalog(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Catalog: " + "id=" + id + ", title='" + title + '\'';
	}


}