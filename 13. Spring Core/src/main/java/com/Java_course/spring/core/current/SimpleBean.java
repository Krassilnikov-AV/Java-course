package com.Java_course.spring.core.current;


import lombok.Data;

@Data
public class SimpleBean {
	private int value;

	public void doSomething() {
		System.out.println("Simple Bean print = " + value);
	}
}