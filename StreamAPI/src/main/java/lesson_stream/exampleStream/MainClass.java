/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package lesson_stream.exampleStream;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class MainClass {

	static class Person {


		enum Position {
			ENGINER, DIRECTOR, MANAGER;
		}

		private String name;
		private int age;
		private Position position;

		public Person(String name, int age, Position position) {
			this.name = name;
			this.age = age;
			this.position = position;
		}

		public int getAge() {
			return age;
		}
	}

	public static void main(String[] args) {


//		List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
//
//		List<Integer> out = integers.stream().filter(new Predicate<Integer>() {
//			@Override
//			public boolean test(Integer integer) {
//				return integer % 2 == 0;
//			}
//		}).collect(Collectors.toList());
//
//		List<Integer> out2 = integers.stream().filter((n) -> {
//			return n % 2 == 0;
//		}).collect(Collectors.toList());           // возвращает либо коллекцию, либо строку, занимается сборкой
//		// объектов
//		System.out.println(out);
//		System.out.println(out2);
//
//		integers.stream().filter((n) -> n % 2 == 1).forEach(integer -> System.out.println(integer));

		/*создание стрима*/
//		Stream.of("A", "BBB", "CCC").map(s -> s.length()).forEach(System.out::println);
//		Stream.of(1, 2, 3).map(new Function<Integer, Integer>() {
//			@Override
//			public Integer apply(Integer integer) {
//				return integer * 10;
//			}
//		}).forEach(System.out::println);

		//		Files.lines(Path.get("text.txt")).map(line -> line.split("\\s"));
//		firstEx();
//		secondEx();
//		thirdEx();
//		matchEx();
//		findAnyEx();
//		mappingEx();
//		reduceEx();
//		intStreamsEx();
//		streamFromFileEx();
//		simpleStringEx();
//		streamFromFileEx_();
//		streamFromThread();
		mostCommon();
	}

	/*найти наиболее встречающееся слово*/
	private static void mostCommon() {
		String input = "kjdf j df iue iue fdj j j";
		String word = Arrays.stream(input.split(" "))
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet().stream()
			.max(Map.Entry.comparingByValue())
			.map(Map.Entry::getKey)
			.orElse(null);
		System.out.println("Most popular word is " + word);
	}

	private static void streamFromThread() {
		IntStream.rangeClosed(0, 1000).parallel().filter(n -> {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
			return n % 2 == 0;
		}).forEach(System.out::println);
	}

	/*Получение уникальных слов из файла */
	private static void streamFromFileEx_() {
		try {
//  в приведённом примере не покажет уникальные слова, т.к. 	distinct() берет уникальные строки из файла
			Files.lines(Paths.get("text.txt"))
				.map(line -> line.split("\\s"))
				.distinct()
				.forEach(arr -> System.out.println(Arrays.toString(arr)));
			System.out.println("-------------------------");
//в приведённом примере покажет поток потоков строк,
			Files.lines(Paths.get("text.txt"))
				.map(line -> line.split("\\s"))
				// заворачиваем каждый массив в поток
				.map(Arrays::stream)
				.distinct()
				.forEach(System.out::println);
			System.out.println("-------------------------");
			System.out.println(Files.lines(Paths.get("text.txt"))
				.map(line -> line.split("\\s"))
				// преобразование каждой строки к массиву-> заворачивание в поток
				.flatMap(Arrays::stream)
				// при помощи distinct() получаем уникальные слова
				.distinct()
				.collect(Collectors.joining(", ", "Уникальные слова: ", ".")));
			System.out.println("-------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*посчитать число уникальных слов при помощи distinct()*/
	private static void simpleStringEx() {
		System.out.println(Arrays.stream("B CC B AA A A B CC L C C".split("\\s")).distinct().count());
	}

	/*Обработка текстовых файлов при помощи стримов
	 * - получение информации сколько символов написано в каждой строке*/
	private static void streamFromFileEx() {
		try {
			Files.lines(Paths.get("123.txt")).map(String::length).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static void streamCreationEx() {
		Arrays.asList("A", "B", "C").stream().forEach(System.out::println);
		Stream.of(1, 2, 3, 4).forEach(System.out::println);
		Arrays.stream(new int[]{4, 3, 2, 1}).forEach(System.out::println);
	}

	/*применение intStreame добавляет возможность использования сецифических методов
	 * - позволяет применять дополнительные методы в отличие от обычного Stream*/
	private static void intStreamsEx() {
		IntStream myIntStream = IntStream.of(10, 20, 30, 40, 50);

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		list.stream().mapToInt(v -> v).sum();
		// rangeClosed  - генерирует числа от 2-х до 10-ти с включением левой и правой границ
		IntStream.rangeClosed(2, 10).filter(n -> n % 2 != 0).forEach(System.out::println);

		Stream.of(new Person("A", 2, Person.Position.ENGINER)).mapToInt(Person::getAge);
	}

	private static void firstEx() {
		List<Person> persons = new ArrayList<>(Arrays.asList(
			new Person("Bob1", 55, Person.Position.MANAGER),
			new Person("Bob2", 35, Person.Position.DIRECTOR),
			new Person("Bob3", 25, Person.Position.ENGINER),
			new Person("Bob4", 42, Person.Position.ENGINER),
			new Person("Bob5", 55, Person.Position.ENGINER),
			new Person("Bob6", 55, Person.Position.MANAGER),
			new Person("Bob7", 55, Person.Position.MANAGER)
		));
		/*пример написания многострочного кода для сортировки и получения имен инженеров*/
		List<Person> engineers = new ArrayList<>();
		for (Person o : persons) {
			if (o.position == Person.Position.ENGINER) {
				engineers.add(o);
			}
		}
		engineers.sort(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.age - o2.age;                 // сортировка в зависимости от возраста
			}
		});
		List<String> engineersNames = new ArrayList<>();
		for (Person o : engineers) {
			engineersNames.add(o.name);                 // получение имен инженеров
		}
		System.out.println(engineersNames);

		/*пример решения сортировки и получения имен инженеров одной строкой*/

		List<String> engineersNamesShortPath = persons.stream()
			.filter(person -> person.position == Person.Position.ENGINER)
			.sorted(((o1, o2) -> o1.age - o2.age))
			.map((Function<Person, String>) person -> person.name)
			.collect(Collectors.toList());
		System.out.println(engineersNamesShortPath);
	}

	private static void secondEx() {
		// Создание списка целых чисел
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<Integer> out = numbers.stream() // преобразование списка целых чисел в поток
			.filter(n -> n % 2 == 0)         // фильтрация потока, оставление в нем чётных чисел
			.map(n -> n * n)                 // преобразование каждого элемента потока int -> int, овзводя в квадрат
			.limit(2)                        // оставляем в потоке только 2 первых элемента
			.collect(Collectors.toList());    // собираем элементы потока в лист
		System.out.println(numbers);
		System.out.println(out);
	}

	private static void thirdEx() {
		//получим поток данных из набора целых чисел, находим среди них только уникальные припомощи метода distinct(),
		// и каждое найденное значение выводим в консоль
		System.out.println("первый вариант thirdEx() ");
		Arrays.asList(1, 2, 3, 4, 5, 6, 7, 2, 8, 3, 5, 4).stream().distinct().forEach(n -> System.out.println(n));
		// делаем тоже самое тлько с более короткой записью System.out::println
		System.out.println("первый вариант thirdEx() ");
		Arrays.asList(1, 2, 3, 4, 5, 6, 7, 2, 8, 3, 5, 4).stream().distinct().forEach(System.out::println);
	}

	/**/
	private static void findAnyEx() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		list.stream().filter(n -> n > 10).findAny().ifPresent(System.out::println);
		Optional<Integer> opt = list.stream().filter(n -> n > 10).findAny();
		if (opt.isPresent()) {
			System.out.println(opt.get());
		}
	}

	/* проверка наличия какого особенного элемента в наборе элементов*/

	private static void matchEx() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(list.stream().allMatch(n -> n < 10));    // все элементы должны удовлетворять условию // true
		System.out.println(list.stream().anyMatch(n -> n == 4));    // хотя бы один эл-т должен быть 4 // true
		System.out.println(list.stream().noneMatch(n -> n == 2));   // хотя бы один эл-т не должен быть 2 // false
		// применение стримов занчительно ссокращает код, можно убедиться ниже
		boolean result = true;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) >= 10) {
				result = false;
				break;
			}
		}
	}

	/*пример сравнения суммы значений из списка при обычном написании и при помощи метода reduceEx() из stream*/
	private static void reduceEx() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		int sum = 0;
		for (Integer o : list) {
			sum += o;
		}

		int streamSum = list.stream().reduce(0, (a, b) -> a + b);
		System.out.println(sum + " " + streamSum);
	}

	/*преобразование одного объекта к другому при помощи маппинга*/
	private static void mappingEx() {
		Function<String, Integer> _strTolen = String::length;
		Function<String, Integer> strTolen = s -> s.length();
		Predicate<Integer> evenNumberFilter = n -> n % 2 == 0;
		Function<Integer, Integer> cube = n -> n * n * n;

		Stream.of(1, 2, 3).map(n -> Math.pow(n, 3));
		Stream.of(1, 2, 3).map(cube);

		List<String> list = Arrays.asList("AA", "BB", "C", "DDD", "EE", "FFF");
		List<Integer> wordsLength = list.stream().map(strTolen).collect(Collectors.toList());
		System.out.println(list);
		System.out.println(wordsLength);

		list.stream().map(strTolen).forEach(n -> System.out.println(n));
		list.stream().map(strTolen).forEach(System.out::println);
	}

}