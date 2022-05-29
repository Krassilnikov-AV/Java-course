package com.javaСourse.hibernate.library_books;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "authors")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "author")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Book> books;

	@Override
	public String toString() {
		String allBooks = "";
		for (Book o : books) {
			allBooks += o.getTitle() + " ";
		}
		return "Author [" + id + " " + name + " " + allBooks + "]";
	}
}