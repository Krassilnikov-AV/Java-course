package com.lesson9.annotation;

import com.lesson9.Cat;

import java.lang.reflect.*;
import java.net.MalformedURLException;

/**
 * Класс Main
 */
public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, MalformedURLException {
		/*способы получения ссылки на класс для просмотра любой информации в нем*/
//		Class stringClass1 = "Java".getClass();
//		Class stringClass2 = String.class;
//		Class stringClass3 = Class.forName("java.lang.String");

//		Class classCat = Cat.class;
//
//		Method[] methods = classCat.getMethods();
//		Method[] privatMetods = classCat.getDeclaredMethods();
//		System.out.println("====== // получение всех public методов класса Cat и методов родителя:");
//		for (Method o : methods) {
//			System.out.println(o.getName());
//		}
//		System.out.println("====== // получение всех имеющихся методов класса Cat:");
//		for (Method o : privatMetods) {
//			System.out.println(o.getName());
//		}

		System.out.println("====== // получение получение конкретного метода из списка класса Cat:");
		Cat cat = new Cat(1, 2, 3);
//		privatMetods[0].invoke(cat);
//		System.out.println("====== // вызов private метода из списка класса Cat:");
//		privatMetods[1].invoke(cat);     // ошибка IllegalAccessException

//		System.out.println("====== // способ вызова private метода из списка класса Cat, при помощи .setAccessible(true):");
//		privatMetods[1].setAccessible(true);
//		privatMetods[1].invoke(cat);

//		System.out.println("=======//Получение объекта другого проекта для работы");
//		ClassLoader classLoader = new URLClassLoader(new URL[]{new File("D:\\REPOSITORIES-2\\Java-course").toURL()});
//		Class humanClass = classLoader.loadClass("Human");
//		Object humanObj=humanClass.getConstructor(String.class, int.class).newInstance("Bob", 30);
//		Method greetingsMetod = humanClass.getDeclaredMethod("greetings");
//		greetingsMetod.invoke(humanObj);

		System.out.println("=====// ");
	}
}