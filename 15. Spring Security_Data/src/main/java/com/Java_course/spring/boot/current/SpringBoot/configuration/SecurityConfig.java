package com.Java_course.spring.boot.current.SpringBoot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

import javax.sql.DataSource;

/**
 * Класс SecurityConfig
 * - DataSource - отвечает за подключение к БД
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private DataSource dataSource;


//	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * Два варианта настройки источников данных выложены в application.properties.
	 * 1-ый вариант: когда данные берутся из БД, в качестве источника jdbcAuthentication()
	 * для работы - сетттер заисимость spring-boot-starter-jdbc
	 */
//
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}
/**
 * 2-ой вариант:
 * В том случае, если известно определённое кол-во пользователей.
 * */
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		User.UserBuilder users = User.withDefaultPasswordEncoder();
//		auth.inMemoryAuthentication()
//			.withUser(users.username("user1").password("pass1").roles("USER", "ADMIN"))
//			.withUser(users.username("user2").password("pass2").roles("USER"));
//	}

	/**
	 * Прописание правила доступа, описание запросов которых необходимо обезопасить
	 * -.anyRequest().permitAll() - абсолютно всем авторизованным польз-ям разрешается гулять
	 * -.antMatchers("/secured/**") - есть блок сайта (админка), которую необходимо защитить
	 * -.hasAnyRole("ADMIN") - необходимы права админа
	 * -.antMatchers("/products/edit**").hasAnyRole("MANAGER", "ADMIN") -в данный блок необходимы права менеджера и	 админа
	 * -.httpBasic() - базовая уатентификация (логин, пароль) (старенькое окошко)
	 * -.formLogin() - так же можно использовть, стандартная форма
	 * -.loginPage("/login").loginProcessingUrl("/authenticateTheUser") - форма логина и указание места запроса
	 * -
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//			.anyRequest().permitAll()
//			.antMatchers("/secured/**").hasAnyRole("ADMIN")
			.antMatchers("/products/show**").hasAnyRole("ADMIN")
			.anyRequest().permitAll()
			.and()
//			.httpBasic();
			.formLogin()
////			.loginPage("/login")
////			.loginProcessingUrl("/authenticateTheUser")
			.permitAll();
	}
}