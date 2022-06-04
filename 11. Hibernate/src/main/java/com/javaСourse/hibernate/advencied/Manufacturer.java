package com.javaСourse.hibernate.advencied;

import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "manufacturers")
public class Manufacturer {

	@Id
	@Column(name = "id")
	@GeneratedValue
	Long id;

	@Column(name = "title")
	String title;
	/**
	 * FetchType.EAGER - достаёт все объекты сразу, их можно запрашивать после завершения сессии
	 * FetchType.LAZY - когда есть ссылка на продукты, но она пустая (т.е. загрузка по требованию)
	 * - для того чтоб достать продукты из него нужно сделать getProduts()
	 * !!!! ОСОБЕННОСТИ: если транзакция не завершена, то  он дотягивает эти продукты,
	 * а если транзакция прекратилась у него нет
	 * возможности отправить запрос и доспросить и он выкидывает Exception
	 */
	@OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY)
	List<Product> products;

	@Formula("(SELECT avg(p.price) FROM products p WHERE p.manufacturer_id = id)")
	BigDecimal avgProductsPrice;


}