package com.Java_course.spring.core.current;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppSpringCore {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("MyContext.xml");

		SimpleBean simpleBean1 = context.getBean("simpleBean", SimpleBean.class);

		SimpleBean simpleBean2 = context.getBean("simpleBean", SimpleBean.class);

		simpleBean1.doSomething();
		simpleBean2.doSomething();
		simpleBean1.setValue(5);
		simpleBean2.setValue(10);
		simpleBean1.doSomething();
		simpleBean2.doSomething();
/*  в данном случае вывод:
		Simple Bean print = 0
		Simple Bean print = 0
		Simple Bean print = 10
		Simple Bean print = 10
Для того, что бы значение присваивалось чрез сеттер только новому объкту, необходимо прописать
 в бине файла xml scope="prototype", после чего, при изменении значения, вывод будет только
 у изменившегося объекта (бина), выод следующий:
 Simple Bean print = 0
Simple Bean print = 0
Simple Bean print = 5
Simple Bean print = 10
		*/

// запросит бин через сеттер
		CodeCreator codeCreator = context.getBean("javaCodeCreator", CodeCreator.class);
		System.out.println(codeCreator.getClassExample());
// запросит бин через конструктор
//		CodeCreator cppCodeCreator = context.getBean("cppCodeCreator", CodeCreator.class);
//		System.out.println(cppCodeCreator.getClassExample());
//		context.close();
		/*!!! дважды конструктор не вызовет. В данном случае вызовет создание фигуры*/
		CodeCreator cppCodeCreator1 = context.getBean("cppCodeCreator1", CodeCreator.class);
		System.out.println(cppCodeCreator1.getClassExample());
		context.close();
	}
}