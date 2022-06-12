package com.Java_course.spring.core.current.simple;

import org.springframework.stereotype.Component;

/**
 * MailService - сервис отсылать письма с подтверждением заказа
 */
@Component
public class MailService {
	public void sendMail() {
		System.out.println("Письмо отправлено");
	}
}
