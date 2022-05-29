package com.javaСourse.hibernate.library_books;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "readers")
public class Reader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToMany
	@JoinTable(
		name = "books_readers",
		joinColumns = @JoinColumn(name = "reader_id"),
		inverseJoinColumns = @JoinColumn(name = "book_id")
	)
	private List<Book> books;

	@Override
	public String toString() {
		String allBooks = "";
		for (Book o : books) {
			allBooks += o.getTitle() + " ";
		}
		return "Reader [" + id + " " + name + " " + allBooks + "]";
	}
}
