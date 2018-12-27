package ua.kiev.prog.hibernate_HomeWork;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class menuApp {
	static EntityManagerFactory emf;
	static EntityManager em;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		emf = Persistence.createEntityManagerFactory("MenuApp");
		em = emf.createEntityManager();
		addDish("egg",12,300,0);
		addDish("roar beef",200,500,0);
		addDish("bread",10,1000,25);
		try {
			while (true) {
				System.out.println("1: price from-to");
				System.out.println("2: with discount");
				System.out.println("3: set with 1 kilo");
				System.out.print("-> ");
				String s = sc.nextLine();
				switch (s) {
					case "1":
						break;
					case "2":
						break;
					default:
						return;
				}
			}
		} finally {
			sc.close();
			em.close();
			emf.close();
		}
	}

	private static void addDish(Scanner sc) {
		System.out.println("Input dish name: ");
		String name = sc.next();
		System.out.println("Input dish price: ");
		int price = sc.nextInt();
		System.out.println("Input dish weight: ");
		int weight = sc.nextInt();
		System.out.println("Input dish discount(int percent): ");
		int discont = sc.nextInt();
		addDish(name, price, weight, discont);
	}

	private static void addDish(String name, int price, int weight, int discont) {
		em.getTransaction()
				.begin();
		try {
			menu menu = new menu(name, price, weight, discont);
			em.persist(menu);
			em.getTransaction()
					.commit();
		} catch (Exception ex) {
			em.getTransaction()
					.rollback();
		}
	}
}
