package com.javaСourse.hibernate.customer_1;

import javax.persistence.NoResultException;
import java.util.*;


public class ProgramInterface {

	private Scanner scanner = new Scanner(System.in);
	private ProductService ps = new ProductService();
	private CustomerService cs = new CustomerService();

	public void getStart() {
		System.out.println("Welcome to the supermarket! ");

		int choice;

		do {
			System.out.println("\nWhat u want to do?\n" +
				"1. /showProductsByPerson\n" +
				"2. /findPersonsByProductTitle\n" +
				"3. /removePerson\n" +
				"4. /removeProduct\n" +
				"5. /byu\n" +
				"0. /quit");
			while (!scanner.hasNextInt()) {
				System.out.println("Number between 0 and 5 please!");
				scanner.next();
			}
			choice = scanner.nextInt();
			switch (choice) {
				case 1:
					System.out.println("Enter customer name please");
					String customerName = scanner.next();

					try {
						Set<CustomerProduct> cp = cs.findByName(customerName).getProducts();
						for (CustomerProduct customerProduct : cp) {
							System.out.println(customerProduct.toString());
						}
					} catch (NoResultException ex) {
						System.out.println("There is no customer with this name!");
					}
					break;
				case 2:
					System.out.println("Enter product name please");
					String productName = scanner.next();
					try {
						Set<CustomerProduct> cp2 = ps.findByName(productName).getCustomers();
						for (CustomerProduct customerProduct : cp2) {
							System.out.println(customerProduct.toString());
						}
					} catch (NoResultException ex) {
						System.out.println("There is no product with this name!");
					}
					break;

//			case 3:
//				System.out.println("Enter customer name please");
//				customerName = scanner.next();
//				try{
//					Set<CustomerProduct> cp2=ps.findByName(productName).getCustomers();
//					for (CustomerProduct customerProduct:cp2) {
//						System.out.println(customerProduct.toString());
//					}
//				} catch (NoResultException ex) {
//					System.out.println("There is no product with this name!");
//				}
//				break;
			}

		} while (choice != 0);
	}
}