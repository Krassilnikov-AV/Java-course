package com.Java_course.spring.core.current;

public class JavaCodeCreator implements CodeCreator {
	ClassNameGenerator classNameGenerator;
/**
 * Spring создал объект и заэнжектил на Бин ClassNameGenerator
 * */
	public void setClassNameGenerator(ClassNameGenerator classNameGenerator) {
		this.classNameGenerator = classNameGenerator;
	}

	public String getClassExample() {
		return "public class " + classNameGenerator.generateClassName() + "{\n\n}";
	}
}