/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package task.zadanie_1;


import java.io.FileReader;
import java.util.*;

public class ReaderService {

	public Set<LineEntity> readFile() {
		Set<String> lineEntities = new LinkedHashSet<>();

		try (FileReader reader = new FileReader("task.txt")) {
			char[] buf = new char[256];
			int c;
			while ((c = reader.read(buf)) > 0) {
				if (c < 256) {
					buf = Arrays.copyOf(buf, c);
				}
			}
			lineEntities.add(new String(buf).intern());

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(lineEntities);
		return convertToEntyti(lineEntities);
	}

	private Set<LineEntity> convertToEntyti(Set<String> lineEntities) {
		Set<LineEntity> result = new HashSet<>();
		for (String str : lineEntities) {
			Map<Integer, String> map = new HashMap<>();
			String[] strings = str.split(";");
			for (int i = 0; i < strings.length; i++) {
				map.put(i, strings[i]);
			}
			result.add(new LineEntity(map));
		}
		return result;
	}

//	private static void streamFromFileEx() {
//		try {
//			Files.lines(Paths.get("task.txt"))
//				.map(convert());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static LineEntity convert() {
//
//	}


}