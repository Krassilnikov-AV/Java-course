/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package task.example;

/**
 * Класс MainAppTaskSimpleSwap
 */
public class MainAppTaskSimpleSwap {

	public static void main(String[] args) {

		int arr[] = {15, 63, 44, 14, 33, 36};

		swappingPlaces(arr, 3, 2);
	}

	static void swappingPlaces(int arr[], int i, int j) {

		System.out.println("Исходный массив:");
		for (int t = 0; t < arr.length; t++)
			System.out.print(arr[t] + " ");  //15 63 44 14 33 36
		System.out.println();
		System.out.println("результат:");
		int g = arr[i];
		arr[i] = arr[j];
		arr[j] = g;
		for (int t = 0; t < arr.length; t++) {
			System.out.print(arr[t] + " ");  //15 33 44 14 63 36
		}
	}
}