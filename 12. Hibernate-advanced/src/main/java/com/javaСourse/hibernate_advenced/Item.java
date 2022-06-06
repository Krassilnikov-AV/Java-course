package com.javaСourse.hibernate_advenced;


import lombok.*;

import javax.persistence.*;


@Data
@Table(name = "items")
@NoArgsConstructor
public class Item {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "val")
	int val;

	@Version
	long version;
}