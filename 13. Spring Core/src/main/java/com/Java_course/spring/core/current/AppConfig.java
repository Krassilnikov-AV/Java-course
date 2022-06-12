package com.Java_course.spring.core.current;

import org.springframework.context.annotation.*;

/**
 * AppConfig - в данном классе прописываются все настройки бинов
 */
@Configuration // - говорит о том,ч то файл является конфигурационным

/**
 * =============  Взятые настройки с xml конфигации, для визуализации замены на аннотации ================
 *
 * <bean id="animalsClassNameGenerator" class="com.Java_course.spring.core.current.AnimalsClassNameGenerator"/>
 * <bean id="javaCodeCreator" class="com.Java_course.spring.core.current.JavaCodeCreator">
 * <property name="classNameGenerator">
 * <ref bean="animalsClassNameGenerator" />
 * </property>
 * </bean>
 *
 * <bean id="simpleBean" class="com.Java_course.spring.core.current.SimpleBean"/>
 * =======================================================================================================
 */
/*указание пакета, местонахождения */
@ComponentScan("com.Java_course.spring.core.current")
/*@ComponentScan - для того, что бы понять спрингу какие бины создавать, он просканирует папку, расположенную по
указанному пути на наличие классов, которые помечены @Component. И после того создаст на данные классы бины.
*/
public class AppConfig {
	/*===================== Простой случай создания бина =========================================*/
	/*
	 * применение методов - бинов вместо xml конфигурации
	 * */
	@Bean     // - анотация для считывания в конфигурационном файле описываемого бина
	public SimpleBean simpleBean() {
		SimpleBean simpleBean = new SimpleBean();
		return simpleBean;
	}

	/*================== Более сложный случай создания бина, через сеттер класса JavaCodeCreator.======*/
	/*
	 * Бин класса JavaCodeCreator */
	@Bean
	public CodeCreator javaCodeCreator() {
		JavaCodeCreator codeCreator = new JavaCodeCreator();
		// получение ссылки на другой бин
		codeCreator.setClassNameGenerator(animalsClassNameGenerator());
		return codeCreator;
	}

	/* Бин класса AnimalsClassNameGenerator */
	@Bean
	public ClassNameGenerator animalsClassNameGenerator() {
		ClassNameGenerator classNameGenerator = new AnimalsClassNameGenerator();
		return classNameGenerator;
	}

}