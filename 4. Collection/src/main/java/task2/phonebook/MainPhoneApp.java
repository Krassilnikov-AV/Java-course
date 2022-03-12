/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package task2.phonebook;

/**
 * Класс MainPhoneApp
 */
public class MainPhoneApp {
	public static void main(String[] args) {
		PhoneBook phoneBook=new PhoneBook();
		phoneBook.add("Пушкин", "+79151237895");
		phoneBook.add("Ионова", "+79151256124");
		phoneBook.add("Пушкин", "+79279562348");
		phoneBook.add("Пушкин", "+79179514679");

		System.out.println(phoneBook.getAllFio());
		System.out.println(phoneBook.getPhoneNumberByFio("Пушкин"));
		System.out.println(phoneBook.hmPhoneBook);
	}



}