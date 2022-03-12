/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package task2.phonebook;

public class MainPhoneApp {
	public static void main(String[] args) {
		PhoneBook phoneBook = new PhoneBook();
		phoneBook.add("Пушкин", "+79151237895");
		phoneBook.add("Ионова", "+79151256124");
		phoneBook.add("Пушкин", "+79279562348");
		phoneBook.add("Пушкин", "+79179514679");

		phoneBook.getAllFio().forEach(e -> System.out.println("[" + e + "] - " + phoneBook.getPhoneNumberByFio(e)));
	}
}