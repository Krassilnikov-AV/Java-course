package com.javaСourse.hibernate.advencied;

import com.javaСourse.hibernate.customer_1.Product;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "demo_annotated", indexes = {
	@Index(name = "name_idx", columnList = "name"),
	@Index(name = "id_name_idx", columnList = "id, name"),
	@Index(name = "unique_name_idx", columnList = "name", unique = true),
})
public class VeryAnnotatedClass {

	@Id
	@GeneratedValue
	@Column(name = "id")
	Long id;

	@Column(name = "name")
	String name;

	@Column(name = "weight")
	float weight;
	/**
	 * - сгенерится строка на 255 символов
	 * - для точного кол-ва символов, указать length=10
	 * - nullable -
	 */
	@Column(name = "short_str", nullable = false, length = 10)  // varchar
		float shortString;
	/**
	 * @ColumnTransformer - перевод единиц измерения в необходимые величины
	 */
	@Column(name = "weight")
	@ColumnTransformer(
		read = "weight / 2.0",
		write = "? * 2.0"
	)
	float dividedWeight;
	/**
	 * получение средней стоимости продукта,
	 * при этом id производителя должен быть равен id производителя
	 * !!! - прсчитывается при получении объекта из БД, если уже объект вытащили, то формула кадый раз не
	 * пересчитывается
	 */
	@Formula("SELECT avg(p.cost) FROM Product p WHERE p.manufacturer_id=id")
	BigDecimal avgManufacturerProductCost;
	/**
	 * Хранение даты и времени
	 * - updatable = false - это поле нельзя изменять
	 * - @CreationTimestamp - сам hibernate должене сохранить мормент времени в БД
	 */
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "create_at", updatable = false)
//	@CreationTimestamp
//	LocalDateTime createdAt;
	/**
	 * @UpdateTimestamp - аннотация обновляет время в таблице
	 */

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_at")
	@UpdateTimestamp
	LocalDateTime updateAt;
	/**
	 * - столбец можоно описать вручную
	 */
	@Column(name = "manual_def_str", columnDefinition = "VARCHAR(50) NOT NULL UNIQUE CHECK (NOT suk)")
	String manualDefinedString;
	/**
	 * указание внешнего ключа
	 */
	@ManyToOne
	@JoinColumn(
		name = "product_id",
		nullable = false,
		foreignKey = @ForeignKey(name = "FK_PRODUCT_ID")
	)
	Product product;
	/**
	 *
	 */
	@Version
	long version;
}