/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.javaСourse.hibernate;

import org.hibernate.annotations.Table;

import javax.persistence.*;

/**
 * Класс Catalog
 */
@Entity // аннотация сущность, говорит о том что объекты данного класса смогут маппиться с БД

@Table(name="catalogs") // таблица и ее имя
public class Catalog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY);
	@Column(name="id")
	private Long id;
}