/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package task2.words;

public class MainAppTask2 {

	public static void main(String[] args) {
		String[] str =
			{"Улица", "Дом", "Улица", "Дом", "Участок", "Площадь",
				"Корабль", "Пароход", "Дача", "Улица", "Огород", "Дом"};
		findAndCountUniqueWords(str);
//		Map<String, Integer> mapString=new HashMap<>();
//
//		for (String string:str) {
//			if(!mapString.containsKey(string)) {
//				mapString.put(string, 1);
//			} else {
//				mapString.put(string, mapString.get(string)+1);
//			}
//		}
//		for (Map.Entry<String, Integer>entry:mapString.entrySet()) {
//			System.out.println(entry.getKey());
//		}

	}
/*короткий вариант */
	public static void findAndCountUniqueWords(String... arr) {
		HashMap<String, Integer> hm = new HashMap<>();
		for (String str : arr) {
			hm.put(str, hm.getOrDefault(str, 0) + 1);
		}
		System.out.println(hm);
		System.out.println(hm.keySet());
	}
}