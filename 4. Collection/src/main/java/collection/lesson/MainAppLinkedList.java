/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package collection.lesson;

import java.util.*;

public class MainAppLinkedList {
/*Пример быстроты сортировки allist и llist*/
	public static void main(String[] args) {
		List allist = new ArrayList(1000000);
		List llist = new LinkedList();

		for (int i = 0;	i < 1000000; i++) {
			int x = (int) (Math.random() * 5000);
			allist.add(x);
			llist.add(x);
		}
		long time=System.currentTimeMillis();
		Collections.sort(allist);
		System.out.println("time: "+ (System.currentTimeMillis() - time));

		time=System.currentTimeMillis();
		Collections.sort(llist);
		System.out.println("time: "+ (System.currentTimeMillis() - time));
	}
}