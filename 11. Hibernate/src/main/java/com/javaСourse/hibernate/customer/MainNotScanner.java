package com.javaСourse.hibernate.customer;

//public class MainNotScanner {
//
//	public static void main(String[] args) {
//		SessionFactory factory = new Configuration()
//			.configure("hibernate.cfg.xml")
//			.addAnnotatedClass(Customer.class)
//			.addAnnotatedClass(Product.class)
//			.addAnnotatedClass(Order.class)
//			.addAnnotatedClass(OrderKey.class)
//			.buildSessionFactory();
////CRUD
//		Session session = null;
//
//		try {
////			Scanner sc = new Scanner(System.in);
////			System.out.println("Enter command: ");
//
////================== занесение нового клиента в БД ============
//
////						session = factory.getCurrentSession();
////						Customer_1 customer = new Customer_1();
////						customer.setName("Ляпис Ряпис");
////						session.beginTransaction();
////						session.save(customer);
////						session.getTransaction().commit();
//
////================== занесение нового прожукта в БД ============
////
////						session = factory.getCurrentSession();
////						Product product = new Product();
////						product.setTitle("пельмени");
////						product.setCost(305.23);
////						session.beginTransaction();
////						session.save(product);
////						session.getTransaction().commit();
//
////================== занесение списка покупок в БД таблица customer_product============
////					case ("/buy"):
////						session = factory.getCurrentSession();
//
////						break;
////================== /showProductsByPerson - просмотр покупок клиента из БД ============
//
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//
//			Customer customerBuy = new Customer();
//			session.createQuery("FROM Customer c WHERE c.name =:name")
//				.setParameter("name", customerBuy.getName()).getSingleResult();
////						Customer_1 customerBuy = (Customer_1) session   //
////							.createQuery()
////							.setParameter().getSingleResult();
//			Product productBuy = new Product();
//			session.createQuery("FROM Product p WHERE p.title =:title")
//				.setParameter("title", productBuy.getTitle()).getSingleResult();
//			session.createQuery("FROM Product p WHERE p.coste =:cost")
//				.setParameter("cost", productBuy.getCost()).getSingleResult();
////						Product productBuy = (Product) session
////							.createQuery("FROM Product p WHERE p.title =:title")
////							.setParameter("title", commandParts[2]).getSingleResult();
//
//			OrderKey orderKey = new OrderKey();
//			orderKey.setCustomerId(customerBuy.getId());
//			orderKey.setProductId((long) productBuy.getId());
//
//			Order order = new Order();
//			order.setOrderKey(orderKey);
//			order.setCost(productBuy.getCost());
//
//			session.save(order);
//			session.getTransaction().commit();
//			System.out.println("Saved order" + order.toString());
//			System.out.println("Enter new command: ");
//
//
////						System.out.println("/buy");
////						session = factory.getCurrentSession();
////						session.beginTransaction();
////
////						Customer_1 customer = (Customer_1) session
////						.createQuery("FROM customers c WHERE c.name = :name")
////						.setParameter("name", commandParts[1]).getSingleResult();
////						Product product = (Product) session
////							.createQuery("FROM products p WHERE p.name = :name")
////							.setParameter("name", commandParts[2]).getSingleResult();
////
////						OrderKey orderKey = new OrderKey();
////						orderKey.setCustomerId(customer.getId());
////						orderKey.setProductId(product.getId());
////
////						Order order=new Order();
////						order.setOrderKey(orderKey);
////						order.setPrice(order.getPrice());
////
////						session.save(order);
////
////						session.getTransaction().commit();
////						System.out.println("Saved the next order: "+ order.toString());
////						System.out.println("Enter new command: ");
////						break;
//
//		} finally {
//			factory.close();
//			assert session != null;
//			session.close();
//		}
//	}
//}