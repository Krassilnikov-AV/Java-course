package com.Java_course.spring.core.current;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
/* @Component - говорит о том, что этот класс уже является бином */
public class AnnotatedBean {
	@Autowired
	/*@Autowired - заинжектит simpleBean, одной простой аннотацией*/
		SimpleBean simpleBean;

	public void example() {
		simpleBean.doSomething();
	}
}
