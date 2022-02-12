/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package lesson2;

/**
 * Класс Main
 */
public class MainApp {

//	public static void main(String[] args) {
//		Flyable[] flyables ={
//			new Dock(),
//			new Airplane()
//		};
//		for (Flyable o:flyables) {
//			o.fly();
//		}
//		Flyable somethingFlyable=new Dock();
//		((Dock) somethingFlyable).fly();
//
//	}

	/*Более углубленное понимание контракта интерфейсов*/

//	static class Human {
//		private Car lastCar;
//		private Bicycle lastBicycle;
//		private Skateboard lastSkateboard;
//
//		public void stop() {
//			if (lastCar != null) {
//				lastCar.stop();
//				lastCar = null;
//			}
//		}
//
//		public void drive(Car car) {
//			car.run();
//			lastCar.run();
//		}
//
//		public void drive(Skateboard skateboard) {
//			skateboard.drive();
//		}
//
//		public void drive(Bicycle bicycle) {
//
//		}
//	}
//
//	static class Car {
//
//		public void stop() {
//		}
//		public void run() {
//			System.out.println("Поехал на машине..");
//		}
//	}
//
//	static class Bicycle {
//
//	}
//
//	static class Skateboard {
//
//		public void drive() {
//
//		}
//	}
	/*Такое написание слишком большое и много действий для реализации*/
	/*Для более краткой формы можно создать интерфейс и описать в нем основные действия*/

	static class Human {
		private Transport currentTransport;

		public void stop() {
			if (currentTransport != null) {
				currentTransport.stop();
				currentTransport = null;
			} else {
				System.out.println("А я никуда и не еду");
			}
		}

		public void drive(Transport transport) {
			transport.start();
			this.currentTransport = transport;
		}
	}

	static class Car implements Transport {

		@Override
		public void start() {
			System.out.println("Человек начал ехать на машине..");
		}

		@Override
		public void stop() {
			System.out.println("Человек остановился на машине..");
		}
	}

	static class Bicycle implements Transport {

		@Override
		public void start() {
			System.out.println("Человек начал ехать на велосипеде..");
		}

		@Override
		public void stop() {
			System.out.println("Человек остановился на велосипеде..");
		}
	}

	static class Skateboard implements Transport {

		@Override
		public void start() {
			System.out.println("Человек начал ехать на скейтборде..");
		}

		@Override
		public void stop() {
			System.out.println("Человек остановился на скейтборде..");
		}
	}

	static class Moto implements Transport {

		@Override
		public void start() {
			System.out.println("Человек начал ехать на мотоцикле..");
		}

		@Override
		public void stop() {
			System.out.println("Человек остановился на мотоцикле..");
		}
	}

	public static void main(String[] args) {
//		Moto moto = new Moto();
		/*другой вариант написания через интерфейс*/
//		Transport transport = new Moto();
		/*или на машине меняя всего лишь создание экземпляра другого класса */
		Transport transport = new Car();
		Human human = new Human();
		human.stop();
		human.drive(transport);
		human.stop();
	}

}