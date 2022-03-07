/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package generic.lesson;

public class BoxWithNumbers<N extends Number> {      // защита от других наследуемых типов данных
	private N[] array;

	public BoxWithNumbers(N... array) {    // можно отдать любое кол-ов int-ов
		this.array = array;
	}

	// среднее кол-во коробок
	public double average() {
		double avg = 0.0;
		for (int i = 0; i < array.length; i++) {
			avg += array[i].doubleValue();
		}
		avg /= array.length;
		return avg;
	}

	// сравнение коробок между собой

	// public boolean compareAverage(BoxWithNumbers<N> another) {  // такая конструкция не позволит сравнивать разные
		// типы(int и  float)
	public boolean compareAverage(BoxWithNumbers<?> another) {      // в данном случае можно сравнивать разные типы
		return Math.abs(this.average() - another.average()) < 0.0001;
	}
}