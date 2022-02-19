/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package homeWork_3;

public class MainHomeWork_3 {

	public static void main(String[] args) {

	}

	static void metodException(String[][] twoDimArray) {
		try {
			if (twoDimArray.length != 4 &&
				twoDimArray[0].length != 4) {
				throw new MyArraySizeException();
			}
		} catch () {

		}
		System.out.println();
	}
}