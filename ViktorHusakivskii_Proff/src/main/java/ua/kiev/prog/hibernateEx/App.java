package ua.kiev.prog.hibernateEx;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;
import java.util.Scanner;

public class App {
		static EntityManagerFactory emf;
		static EntityManager em;

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			try {
				// create connection
				emf = Persistence.createEntityManagerFactory("JPATest");
				em = emf.createEntityManager();
				try {
					while (true) {
						System.out.println("1: add few laptops");
						System.out.println("2: get List of laptops ");
						System.out.print("-> ");

						String s = sc.nextLine();
						switch (s) {
							case "1":
								addLaptop(sc);
								break;
							case "2":
								//viewLaptopList();
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
			} catch (Exception ex) {
				ex.printStackTrace();
				return;
			}
		}

		private static void addLaptop(Scanner sc) {
			System.out.print("Enter laptop model: ");
			String model = sc.nextLine();
			System.out.print("Enter enter brand: ");
			String brand = sc.nextLine();
			System.out.println("Enter laptop price");
			String price = sc.nextLine();
			System.out.println("Were laptop used?");
			String isused = sc.nextLine();
			System.out.println("Enter laptop manufactured date");
			Date date = Date.parse(sc.next());
			em.getTransaction().begin();
			try {
				laptop c = new laptop(model,brand,price,isused,date);
				em.persist(c);
				em.getTransaction().commit();
			} catch (Exception ex) {
				em.getTransaction().rollback();
			}
		}

	/*private static void viewLaptopList() {
			Query query = em.createQuery("FROM SimpleClient c", SimpleClient.class);
			List<SimpleClient> list = (List<SimpleClient>) query.getResultList();

			for (SimpleClient c : list)
				System.out.println(c);
		}

		static final String[] NAMES = {"Ivan", "Petr", "Andrey", "Vsevolod", "Dmitriy"};
		static final Random RND = new Random();

		static String randomName() {
			return NAMES[RND.nextInt(NAMES.length)];
		}
	}*/
}
