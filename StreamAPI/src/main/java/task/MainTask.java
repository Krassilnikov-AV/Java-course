/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package task;


import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class MainTask {

	/*
	 * 1. Создайте массив с набором слов, и с помощью Stream API найдите наиболее часто встречающееся; */


	public static void main(String[] args) {
		String[] words = {"a", "bb", "vbn", "a", "bb"};     //массив слов
// создаем поток слов и делаем сборку с группировкой (collect), т.е. были строки и объекты, в них же преобразуем без
// изменений. В качестве ключа испозуем количество этих слов. Сворачивает набор слов в Map,
// в котором ключ - строка и Long - количество
		String streamFromArrays = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(),
			Collectors.counting()))
//Из полчившегося Map выдираем список множества записей и заворачиваем это множество в стрим
			.entrySet().stream()
//среди этого множества найти максимальный элемент по значению(Long), как сравниваем Long и из записи вытягиваем
// значение, тем самым вернется какая то запись
			.max(Comparator.comparingLong(e -> e.getValue()))
//спрашиваем ключ, который есть однозначно
			.get().getKey();
//Выводим в консоль
		System.out.println(streamFromArrays);

	}

}