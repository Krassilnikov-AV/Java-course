/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package task.zadanie_1;

public class Main {

	public static void main(String[] args) {
		ReaderService taskSolution = new ReaderService();
		System.out.println(taskSolution.readFile());
		GroupService groupService=new GroupService();
//		System.out.println(groupService.createGroups(taskSolution.readFile()));
	}
}