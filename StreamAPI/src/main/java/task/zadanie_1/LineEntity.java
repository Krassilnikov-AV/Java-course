/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package task.zadanie_1;

import java.util.*;

public class LineEntity {

	Map<Integer, String> map = new HashMap<>();


	public LineEntity(Map<Integer, String> map) {
		this.map = map;
	}

	public Map<Integer, String> getMap() {
		return map;
	}

	@Override
	public String toString() {
		return "LineEntity{" +
			"map=" + map +
			'}';
	}
}