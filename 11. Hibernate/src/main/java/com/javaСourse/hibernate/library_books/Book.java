package com.javaСourse.hibernate.library_books;

import lombok.*;

import javax.persistence.*;
import java.util.List;

//ALTER TABLE progress_demo
//  ADD FOREIGN KEY (students_id) REFERENCES students (id) ON DELETE CASCADE;
@Data
@Entity
@NoArgsConstructor
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

	@ManyToMany
	@JoinTable(
		name = "books_readers",
		joinColumns = @JoinColumn(name = "book_id"),
		inverseJoinColumns = @JoinColumn(name = "reader_id")
	)
	private List<Reader> readers;

	public List<Reader> getReaders() {
		return readers;
	}

	public void setReaders(List<Reader> readers) {
		this.readers = readers;
	}

	public Book(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book id = " + id
			+ "; Название книги: " + title
			+ "; Имя автора:  " + author.getName() + ".\n";
	}
}
