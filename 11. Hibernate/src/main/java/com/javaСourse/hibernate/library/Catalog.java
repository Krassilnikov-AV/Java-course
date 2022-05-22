/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.javaСourse.hibernate.library;


import javax.persistence.*;

@Entity // аннотация сущность, говорит о том что объекты данного класса смогут маппиться с БД

@Table(name = "catalogs") // таблица и ее имя
public class Catalog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "title")
	private String title;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
// оюязательно дефолтный конструктор
	public Catalog() {
	}

	public Catalog(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Catalog: " +"id=" + id +", title='" + title + '\'';
	}


}