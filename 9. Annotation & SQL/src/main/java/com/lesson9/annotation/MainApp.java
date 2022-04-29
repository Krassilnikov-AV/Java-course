package com.lesson9.annotation;


import com.lesson9.*;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {
	public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
		Class testClass = TestClass.class;
		System.out.println("====// смотреть список методов класса TestClass: ");
		Method[] methods = testClass.getDeclaredMethods();
		for (Method o : methods) {
			if (o.isAnnotationPresent(MyAnno.class)) {
				o.invoke(null);
			}
		}

//		System.out.println("====// смотреть список методов класса TestClass помеченные @Method: ");
		Method[] methodsAnn = testClass.getDeclaredMethods();
		List<Method> executionList = new ArrayList<>();
		for (Method o : methods) {
			if (o.isAnnotationPresent(MyAnno.class)) {
				executionList.add(o);
			}
		}
		executionList.sort((o1, o2) -> o2
			.getAnnotation(MyAnno.class)
			.priority() - o1.getAnnotation(MyAnno.class)
			.priority());
		System.out.println("======// смотреть список методов по приоритету: ");
		executionList = Arrays.stream(methods)
			.filter(m -> m.isAnnotationPresent(MyAnno.class))
			.sorted((o1, o2) -> o2.getAnnotation(MyAnno.class)
				.priority() - o1.getAnnotation(MyAnno.class).priority())
			.collect(Collectors.toList());
		for (Method m : executionList) {
			m.invoke(null);
		}
	}

}