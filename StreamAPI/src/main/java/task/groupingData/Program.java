package task.groupingData;

import java.util.*;
import java.util.stream.*;

/*
 * группировка данных по какому-нибудь признаку, для этого необходимо использовать
 * в связке метод collect() объекта Stream и метод Collectors.groupingBy().
 * Пример:
 * */
public class Program {

	public static void main(String[] args) {

		Stream<Phone> phoneStream = Stream.of(new Phone("iPhone X", "Apple", 600),
			new Phone("Pixel 2", "Google", 500),
			new Phone("iPhone 8", "Apple", 450),
			new Phone("Galaxy S9", "Samsung", 440),
			new Phone("Galaxy S8", "Samsung", 340));

		Map<String, List<Phone>> phonesByCompany = phoneStream.collect(
			Collectors.groupingBy(Phone::getCompany));

		for (Map.Entry<String, List<Phone>> item : phonesByCompany.entrySet()) {

			System.out.println(item.getKey());
			for (Phone phone : item.getValue()) {

				System.out.println(phone.getName());
			}
			System.out.println();
		}
	}
}
/*
 * Таким образом, для создания групп в метод phoneStream.collect() передается вызов функции
 * Collectors.groupingBy(), которая с помощью выражения Phone::getCompany группирует
 * объекты по компании. В итоге будет создан объект Map, в котором ключами являются
 * названия компаний, а значениями - список связанных с компаниями телефонов.
 * */