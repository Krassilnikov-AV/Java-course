/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package lesson_3;

/**
 * Класс MyLibMatrixProccessingException
 */
public class MyLibMatrixProccessingException extends MyLibException {

	private int row;
	private int column;
	private Object value;

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public Object getValue() {
		return value;
	}

	public MyLibMatrixProccessingException(int row, int column, int[][] array) {
		super("Invalid data in [" + row + "; " + column + "]: " + array[row][column]);
		this.row = row;
		this.column = column;
		this.value = array[column][row];
	}
}