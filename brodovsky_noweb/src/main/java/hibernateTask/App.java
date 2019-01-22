package hibernateTask;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            emf = Persistence.createEntityManagerFactory("JPANotebookTask");
            em = emf.createEntityManager();

            try {
                while (true) {
                    System.out.println("1: add notebook");
                    System.out.println("2: view notebooks");
                    System.out.print("-> ");

                    String s = sc.nextLine();
                    switch (s) {
                        case "1":
                            addNotebook(sc);
                            break;
                        case "2":
                            viewNotebooks(sc);
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

    private static void addNotebook(Scanner sc) {
        System.out.println("Enter notebook info:");
        System.out.println("Model:");
        String model = sc.nextLine();
        System.out.println("Brand");
        String brand = sc.nextLine();
        System.out.println("Price:");
        double price = sc.nextDouble();
        System.out.println("Used?");
        boolean isUsed = sc.nextBoolean();
        System.out.println("Date:");
        String date = sc.nextLine();

        LocalDate newDate = LocalDate.parse(date);
        em.getTransaction().begin();

        try {
            Notebook nBook = new Notebook(model, brand, price, isUsed, newDate);
            em.persist(nBook);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    private static void viewNotebooks(Scanner sc) {
        List<Notebook> notebooksList = em.createQuery("FROM Notebook", Notebook.class).getResultList();

        for (Notebook nb: notebooksList) {
            System.out.println(nb);
        }
    }
}
