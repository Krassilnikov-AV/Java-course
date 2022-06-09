package com.Java_course.spring.core.current;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppSpringCore {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("MyContext.xml");

        SimpleBean simpleBean = context.getBean("simpleBean", SimpleBean.class);
		simpleBean.doSomething();

		CodeCreator codeCreator = context.getBean("javaCodeCreator", CodeCreator.class);
		System.out.println(codeCreator.getClassExample());

		context.close();
	}
}