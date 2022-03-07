/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */
package generic.lesson;

public class SimplBox {

	private Object obj;

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public SimplBox(Object obj) {
		this.obj = obj;
	}

	public void inifo() {
		System.out.println(obj.getClass().getSimpleName()+ " "+obj);
	}
}