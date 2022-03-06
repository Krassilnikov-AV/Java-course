/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package lesson_3;

/**
 * Класс MainAppMatrixProccessingExceptioonImp
 */
public class MainAppMatrixProccessingExceptioonImp {

	public static void main(String[] args) {
		int[][] arr = {
			{1, 2, 3},
			{4, 5, 6},
			{12, 8, 9}
		};

		for (int i = 0; i < arr[i].length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 7 || arr[i][j] == 12) {
				throw new MyLibMatrixProccessingException(i, j, arr);
				}
			}
		}
	}
}