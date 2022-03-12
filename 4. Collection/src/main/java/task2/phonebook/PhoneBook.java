/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package task2.phonebook;


public class PhoneBook {
	HashMap<String, HashSet<String>> hmPhoneBook;

	public PhoneBook() {
		hmPhoneBook = new HashMap<>();
	}

	public void add(String fio, String phone) {
		if (!hmPhoneBook.containsKey(fio)) {
			hmPhoneBook.put(fio, new HashSet<>());
		}
		hmPhoneBook.get(fio).add(phone);
	}
	public Set<String> getPhoneNumberByFio(String fio) {
		return hmPhoneBook.get(fio);
	}
	Set<String> getAllFio() {
		return hmPhoneBook.keySet();
	}
}