package ua.kiev.prog.jpa.sample1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
Создать ноутбук (id, model, brand, price, isUsed, date)
    java time
    java time example
    java time example hibernate jpa
сохранить 5 ноутбуков
Вычитать все ноутбуки и вывести на экран
Задание сделать в своём модуле
И запушить в мастер

1. Создание сущности
2. Пишем класс задания
3. Создать персистент юнит
4. Выложить в гит

 */
public class App {
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // create connection
            emf = Persistence.createEntityManagerFactory("JPAExample1");
            em = emf.createEntityManager();
            try {
                while (true) {
                    System.out.println("1: add client");
                    System.out.println("2: add random clients");
                    System.out.println("3: delete client");
                    System.out.println("4: change client");
                    System.out.println("5: view clients");
                    System.out.print("-> ");

                    String s = sc.nextLine();
                    switch (s) {
                        case "1":
                            addClient(sc);
                            break;
                        case "2":
                            insertRandomClients(sc);
                            break;
                        case "3":
                            deleteClient(sc);
                            break;
                        case "4":
                            changeClient(sc);
                            break;
                        case "5":
                            viewClients();
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

    private static void addClient(Scanner sc) {
        System.out.print("Enter client name: ");
        String name = sc.nextLine();
        System.out.print("Enter client age: ");
        String sAge = sc.nextLine();
        int age = Integer.parseInt(sAge);

        em.getTransaction().begin();
        try {
            SimpleClient c = new SimpleClient(name, age);
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    private static void deleteClient(Scanner sc) {
        System.out.print("Enter client id: ");
        String sId = sc.nextLine();
        long id = Long.parseLong(sId);

        SimpleClient c = em.find(SimpleClient.class, id);
        if (c == null) {
            System.out.println("Client not found!");
            return;
        }

        em.getTransaction().begin();
        try {
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    private static void changeClient(Scanner sc) {
        System.out.print("Enter client name: ");
        String name = sc.nextLine();

        System.out.print("Enter new age: ");
        String sAge = sc.nextLine();
        int age = Integer.parseInt(sAge);

        SimpleClient client = null;
        try {
            Query query = em.createQuery("SELECT c FROM SimpleClient c " +
                    "WHERE c.name = :name", SimpleClient.class);
            query.setParameter("name", name);
            client = (SimpleClient) query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("Client not found!");
            return;
        } catch (NonUniqueResultException ex) {
            System.out.println("Non unique result!");
            return;
        }

        em.getTransaction().begin();
        try {
            client.setAge(age);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    private static void insertRandomClients(Scanner sc) {
        System.out.print("Enter clients count: ");
        String sCount = sc.nextLine();
        int clientCount = Integer.parseInt(sCount);

        em.getTransaction().begin();
        SimpleClient client;
        try {
            for (int i = 0; i < clientCount; i++) {
                client = new SimpleClient(randomName(), RND.nextInt(100));
                em.persist(client);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    private static void viewClients() {
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
}


