package com.Java_course.spring.core.current;

public class JavaCodeCreator implements CodeCreator {
	ClassNameGenerator classNameGenerator;

	public void setClassNameGenerator(ClassNameGenerator classNameGenerator) {
		this.classNameGenerator = classNameGenerator;
	}

	public String getClassExample() {
		return "public class Cat " + classNameGenerator.generateClassName() + "{\n\n}";
	}
}