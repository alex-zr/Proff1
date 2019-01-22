package HibernateHomework1;

import javax.persistence.*;
import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        emf = Persistence.createEntityManagerFactory("Menu");


        while (true){
            System.out.println("Select please");
            System.out.println("1.Add  dishes");
            System.out.println("2.Select dishes by price");
            System.out.println("3.Select discounted dishes");
            System.out.println("4.Sample set of dishes up to a kilogram");

            String s = sc.nextLine();
            switch (s){
                case "1" :
                    addDishes();
                    break;
                case "2" :
                    selectDishesByPrice();
                    break;
                case "3" :
                    selectDiscounedDishes();
                    break;
                case "4" :
                     sampleSetUpToKilogram();
                     break;
                     default:
                         return;
            }
        }


    }

    private static void addDishes() {
        Scanner scanner = new Scanner(System.in);
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Menu menu = new Menu();
        System.out.println("Write name");
        menu.setName(scanner.next());
        System.out.println("Write price");
        menu.setPrice(scanner.nextFloat());
        System.out.println("Write weight");
        menu.setWeight(scanner.nextFloat());
        System.out.println("there is a discount?");
        if (scanner.next().equalsIgnoreCase("+")){
        System.out.println("Write discount");
        menu.setDiscount(scanner.nextInt());} else {
            em.persist(menu);
            em.getTransaction().commit();
            em.close();
        }
    }

    private static void selectDishesByPrice() {
        Scanner scanner = new Scanner(System.in);
        em = emf.createEntityManager();
        System.out.println("Write min price");
        float minPrice = scanner.nextFloat();
        System.out.println("Write max price");
        float maxPrice = scanner.nextFloat();

        Query query = em.createQuery(
                "select m from Menu m where m.price> :minPrice AND m.price<:maxPrice", Menu.class);
        query.setParameter("minPrice", minPrice);
        query.setParameter("maxPrice", maxPrice);
        List<Menu> menus = query.getResultList();
        menus.forEach(System.out::println);
        em.close();

    }

    private static void selectDiscounedDishes() {
       em = emf.createEntityManager();
       String queryWithDiscount = "select m from Menu m where m.discount!=null";
       Query query = em.createQuery(queryWithDiscount);
       List<Menu> menus = query.getResultList();
       menus.forEach(System.out::println);
       em.close();
    }

    private static void sampleSetUpToKilogram() {
        em = emf.createEntityManager();
        String queryStr = "select m from  Menu m";
        Query query = em.createQuery(queryStr);
        List<Menu> rezult = query.getResultList();
        em.close();
        List<Menu> menus = new ArrayList<>();
        float totalWeight = 0;
        for (Menu menu:rezult) {
            totalWeight = totalWeight + menu.getWeight();
            while (totalWeight<=1000){
                menus.add(menu);
        }
      }
      menus.forEach(System.out::println);
    }
}