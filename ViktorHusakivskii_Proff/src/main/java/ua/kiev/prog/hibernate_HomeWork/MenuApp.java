package ua.kiev.prog.hibernate_HomeWork;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class MenuApp {
	static EntityManagerFactory emf;
	static EntityManager em;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("JPAMenuApp");
		em = emf.createEntityManager();
		/*addDish("egg",12,300,0);
		addDish("roar beef",200,500,0);
		addDish("bread",10,1000,25);*/
		try {
			while (true) {
				viewMenu();
				System.out.println("1: price from-to");
				System.out.println("2: with discount");
				System.out.println("3: set with 1 kilo");
				System.out.print("-> ");
				String s = sc.nextLine();
				switch (s) {
					case "1":
						firstQuery();
						break;
					case "2":
						secondQuery();
						break;
					case "3":
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
		System.out.println("Input dish discount(in percent): ");
		int discont = sc.nextInt();
		addDish(name, price, weight, discont);
	}

	private static void addDish(String name, int price, int weight, int discont) {
		try {
			em.getTransaction().begin();
			em.persist(new Menu(name, price, weight, discont));
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
	}

	private static void viewMenu() {
		Query query = em.createQuery("FROM Menu", Menu.class);
		List<Menu> list = (List<Menu>) query.getResultList();

		for (Menu m : list){
			System.out.println(m);
		}
	}

	private static void firstQuery(){
		System.out.println("input min price: ");
		int a = sc.nextInt() ;
		System.out.println("input max price: ");
		int b = sc.nextInt();
		Query query = em.createQuery("SELECT Menu.name FROM Menu where Menu.price<:b and Menu.price>:a",Menu.class);
		query.setParameter("a", a);
		query.setParameter("b", b);
		List<Menu> list = (List<Menu>) query.getResultList();
		for (Menu m : list){
			System.out.println(m);
		}
	}

	private static void secondQuery(){
		Query query = em.createQuery("SELECT Menu.name FROM Menu where Menu.discont>0",Menu.class);
		List<Menu> list = (List<Menu>) query.getResultList();
		for (Menu m : list){
			System.out.println(m);
		}
	}

	private static void thirdQuery(){

	}
}