package com.Java_course.spring.core.current.task;

import org.springframework.stereotype.Component;

/**
 * Класс Product
 * 1. Создайте класс Product (id, title, cost);
 */
@Component
/** аннотация Component сказала спрингу, что класс, который ей аннотируем, это бин.*/

public class Product {

	private long id;
	private String title;
	private double cost;

	public Product(long id, String title, double cost) {
		this.id = id;
		this.title = title;
		this.cost = cost;
	}

	public Product(Product product) {

	}

	/**
	 * Возвращает
	 *
	 * @return
	 */
	public long getId() {
		return id;
	}

	/**
	 * Устанавливает
	 *
	 * @param AbstractElement{name='id', isArray=false, isPrimitiveArray=false, isObjectArray=false, isStringArray=false, isCollection=false, isMap=false, isSet=false, isList=false, isPrimitive=true, isString=false, isNumeric=true, isObject=false, isDate=false, isCalendar=false, isBoolean=false, isLong=true, isFloat=false, isDouble=false, isVoid=false, isChar=false, isByte=false, isShort=false, typeName='null', type='long', typeQualifiedName='null', isModifierStatic=false, isModifierPublic=false, isModifierProtected=false, isModifierPackageLocal=false, isModifierPrivate=true, isModifierFinal=false} ::: FieldElement{isConstant=false, isEnum=false, isModifierTransient=false, isModifierVolatile=false}
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Возвращает
	 *
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Устанавливает
	 *
	 * @param AbstractElement{name='title', isArray=false, isPrimitiveArray=false, isObjectArray=false, isStringArray=false, isCollection=false, isMap=false, isSet=false, isList=false, isPrimitive=false, isString=true, isNumeric=false, isObject=true, isDate=false, isCalendar=false, isBoolean=false, isLong=false, isFloat=false, isDouble=false, isVoid=false, isChar=false, isByte=false, isShort=false, typeName='String', type='java.lang.String', typeQualifiedName='java.lang.String', isModifierStatic=false, isModifierPublic=false, isModifierProtected=false, isModifierPackageLocal=false, isModifierPrivate=true, isModifierFinal=false} ::: FieldElement{isConstant=false, isEnum=false, isModifierTransient=false, isModifierVolatile=false}
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Возвращает
	 *
	 * @return
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Устанавливает
	 *
	 * @param AbstractElement{name='cost', isArray=false, isPrimitiveArray=false, isObjectArray=false, isStringArray=false, isCollection=false, isMap=false, isSet=false, isList=false, isPrimitive=true, isString=false, isNumeric=true, isObject=false, isDate=false, isCalendar=false, isBoolean=false, isLong=false, isFloat=false, isDouble=true, isVoid=false, isChar=false, isByte=false, isShort=false, typeName='null', type='double', typeQualifiedName='null', isModifierStatic=false, isModifierPublic=false, isModifierProtected=false, isModifierPackageLocal=false, isModifierPrivate=true, isModifierFinal=false} ::: FieldElement{isConstant=false, isEnum=false, isModifierTransient=false, isModifierVolatile=false}
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
}