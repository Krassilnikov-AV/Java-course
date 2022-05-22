package com.javaСourse.hibernate.customer;


import com.javaСourse.hibernate.library.Author;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;
	@Column(name = "cost")
	private Double cost;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;


	@JoinTable(
		name = "books_readers",
		joinColumns = @JoinColumn(name = "book_id"),
		inverseJoinColumns = @JoinColumn(name = "reader_id")
	)
}