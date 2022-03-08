/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package task;

import java.util.Arrays;

/**
 * Класс MainAppTask
 */
public class MainAppTask {

	public static void main(String[] args) {
		String[] arr = {"A", "B", "C", "E", "D"};
		System.out.println("Начальный массив: " + Arrays.toString(arr));

		swap(arr, 3, 4);
		System.out.println("Результат: " + Arrays.toString(arr));
	}

	public static void swap(Object[] arr, int n1, int n2) {
		Object obj = arr[n1];
		arr[n1] = arr[n2];
		arr[n2] = obj;
	}
}