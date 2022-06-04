package com.javaСourse.hibernate.advencied;

import lombok.*;
import org.hibernate.annotations.OptimisticLock;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "big_items")
public class BigItem {

	@Id
	@GeneratedValue
	@Column(name = "id")
	Long id;

	@Column(name="val")
	int val;

	@Column(name="junkField")
		@OptimisticLock(excluded = true)
	int junkField;

	@Version
	long version;
}