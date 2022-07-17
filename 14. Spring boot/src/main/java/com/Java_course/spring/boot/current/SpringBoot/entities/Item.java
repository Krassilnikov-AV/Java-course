package com.Java_course.spring.boot.current.SpringBoot.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "items")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "title")
	private String title;
//
//	public Item() {
//	}
//
//	public Item(Long id, String title) {
//		this.id = id;
//		this.title = title;
//	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
}