/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */
package task.fruit;

public abstract class Fruit {
	float weight;

	public float getWeight() {
		return weight;
	}

	public Fruit(float weight) {
		this.weight = weight;
	}
}